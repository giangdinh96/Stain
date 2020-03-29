package com.returnnotfound.stain.base.utils

import android.annotation.SuppressLint
import android.content.ContentUris
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.DocumentsContract
import android.provider.MediaStore
import android.text.TextUtils
import android.webkit.MimeTypeMap
import com.returnnotfound.stain.base.MIME_TYPE_IMAGE_JPEG
import java.io.File

object FileUtils {
  @SuppressLint("NewApi")
  @JvmStatic
  fun getPathFromUri(context: Context, uri: Uri): String? {
    val isKitKat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT
    // DocumentProvider
    if (isKitKat && DocumentsContract.isDocumentUri(context, uri)) {
      // ExternalStorageProvider
      if (isExternalStorageDocument(uri)) {
        val docId = DocumentsContract.getDocumentId(uri)
        val split = docId.split(":").toTypedArray()
        val type = split[0]
        if ("primary".equals(type, ignoreCase = true)) {
          return Environment.getExternalStorageDirectory()
            .toString() + "/" + split[1]
        }
      } else if (isDownloadsDocument(uri)) {
        var cursor: Cursor? = null
        try {
          cursor = context.contentResolver.query(
            uri,
            arrayOf(MediaStore.MediaColumns.DISPLAY_NAME),
            null,
            null,
            null
          )
          if (cursor != null && cursor.moveToFirst()) {
            val fileName = cursor.getString(0)
            val path = Environment.getExternalStorageDirectory()
              .toString() + "/Download/" + fileName
            if (!TextUtils.isEmpty(path)) {
              return path
            }
          }
        } finally {
          cursor?.close()
        }
        val id = DocumentsContract.getDocumentId(uri)
        return try {
          val contentUri = ContentUris.withAppendedId(
            Uri.parse("content://downloads/public_downloads"),
            java.lang.Long.valueOf(id)
          )
          getDataColumn(
            context,
            contentUri,
            null,
            null
          )
        } catch (e: NumberFormatException) {
          //In Android 8 and Android P the id is not a number
          uri.path!!.replaceFirst("^/document/raw:".toRegex(), "")
            .replaceFirst("^raw:".toRegex(), "")
        }
      } else if (isMediaDocument(uri)) {
        val docId = DocumentsContract.getDocumentId(uri)
        val split = docId.split(":").toTypedArray()
        val type = split[0]
        var contentUri: Uri? = null
        if ("image" == type) {
          contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        } else if ("video" == type) {
          contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI
        } else if ("audio" == type) {
          contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        }
        val selection = "_id=?"
        val selectionArgs = arrayOf(
          split[1]
        )
        return getDataColumn(
          context,
          contentUri,
          selection,
          selectionArgs
        )
      }
    } else if ("content".equals(uri.scheme, ignoreCase = true)) {

      // Return the remote address
      return if (isGooglePhotosUri(uri)) uri.lastPathSegment else getDataColumn(
        context,
        uri,
        null,
        null
      )
    } else if ("file".equals(uri.scheme, ignoreCase = true)) {
      return uri.path
    }
    return null
  }

  @JvmStatic
  fun getDataColumn(
    context: Context,
    uri: Uri?,
    selection: String?,
    selectionArgs: Array<String>?
  ): String? {
    var cursor: Cursor? = null
    val column = "_data"
    val projection = arrayOf(
      column
    )
    try {
      cursor = context.contentResolver.query(
        uri!!, projection, selection, selectionArgs,
        null
      )
      if (cursor != null && cursor.moveToFirst()) {
        val index = cursor.getColumnIndexOrThrow(column)
        return cursor.getString(index)
      }
    } finally {
      cursor?.close()
    }
    return null
  }

  @JvmStatic
  fun isExternalStorageDocument(uri: Uri): Boolean {
    return "com.android.externalstorage.documents" == uri.authority
  }

  @JvmStatic
  fun isDownloadsDocument(uri: Uri): Boolean {
    return "com.android.providers.downloads.documents" == uri.authority
  }

  @JvmStatic
  fun isMediaDocument(uri: Uri): Boolean {
    return "com.android.providers.media.documents" == uri.authority
  }

  @JvmStatic
  fun isGooglePhotosUri(uri: Uri): Boolean {
    return "com.google.android.apps.photos.content" == uri.authority
  }

  @JvmStatic
  fun getMimeType(file: File): String? {
    var path = file.path
    path = path.replace(" ", "")
    val extension = MimeTypeMap.getFileExtensionFromUrl(path).toLowerCase()
    var mimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension)
    if (StringUtils.isNullOrEmpty(mimeType)) {
      mimeType = MIME_TYPE_IMAGE_JPEG
    }
    return mimeType
  }

  @JvmStatic
  fun getSize(path: String?): Long {
    val file = File(path)
    return file.length()
  }

  @JvmStatic
  fun getSizeMB(path: String?): Long {
    val file = File(path)
    return file.length() / 1024 / 1024
  }
}
package com.returnnotfound.stain.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.Matrix
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import com.returnnotfound.stain.App
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

const val FILE_EXTENSION = ".JPG"
val CACHE_PATH: String = App.instance!!.cacheDir.absolutePath

object ImageUtils {
  fun getBitmapFromLocal(path: String?): Bitmap {
    val options = BitmapFactory.Options()
    options.inJustDecodeBounds = false
    return BitmapFactory.decodeFile(path, options)
  }

  fun getBitmapFromLocal(path: String?, options: BitmapFactory.Options?): Bitmap {
    return BitmapFactory.decodeFile(path, options)
  }

  fun saveBitmap(data: Bitmap?): String {
    val imageName = "${System.currentTimeMillis()}$FILE_EXTENSION"
    val pathImage = CACHE_PATH.toString() + imageName
    saveBitmap(data, pathImage)
    return pathImage
  }

  fun saveBitmap(bitmap: Bitmap?, file: String): Boolean {
    var bitmapResult = bitmap
    val bytes = ByteArrayOutputStream()
    bitmapResult?.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
    val f = File(file)
    return try {
      if (!f.exists()) {
        f.createNewFile()
      }
      // write the bytes in file
      val fo = FileOutputStream(f)
      fo.write(bytes.toByteArray())

      // remember close de FileOutput
      fo.close()
      bitmapResult?.recycle()
      bitmapResult = null
      true
    } catch (e: IOException) {
      bitmapResult?.recycle()
      false
    }
  }

  private fun rotateImage(bitmap: Bitmap, rotate: Int): Bitmap {
    val rotateBitmap: Bitmap
    rotateBitmap = if (rotate > 0) {
      val matrix = Matrix()
      matrix.postRotate(rotate.toFloat())
      Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true)
    } else {
      bitmap
    }
    return rotateBitmap
  }

  fun getDrawable(radius: Int, color: String?): Drawable {
    val gradientDrawable = GradientDrawable()
    gradientDrawable.cornerRadius = radius.toFloat()
    try {
      gradientDrawable.setColor(Color.parseColor(color))
    } catch (e: Exception) {
      gradientDrawable.setColor(Color.parseColor("#de4242"))
    }
    return gradientDrawable
  }
}
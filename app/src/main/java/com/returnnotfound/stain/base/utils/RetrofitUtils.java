package com.returnnotfound.stain.base.utils;

import android.webkit.MimeTypeMap;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class RetrofitUtils {
  public static MultipartBody.Part getMultipartBodyPart(String name, File file) {
    String mimeTypeString = FileUtils.getMimeType(file);
    String extension = MimeTypeMap.getFileExtensionFromUrl(file.getPath());
    RequestBody requestBody = RequestBody.create(file, MediaType.parse(mimeTypeString));
    return MultipartBody.Part.createFormData(name, "file_" + System.currentTimeMillis() + "." + extension, requestBody);
  }
}

package com.returnnotfound.stain.widget.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.RequestBuilder;
import com.returnnotfound.stain.App;
import com.returnnotfound.stain.R;
import com.returnnotfound.stain.utils.ContextUtils;

public interface ImageLoader {
  String FILE_EXTENSION = ".JPG";
  int DEFAULT_PLACE_HOLDER = R.drawable.image_placeholder;
  String CACHE_PATH = App.Companion.getInstance().getCacheDir().getAbsolutePath();

  RequestBuilder<Drawable> getRequestBuilderDefault(ImageView imageView);

  // Load with String
  void loadImage(ImageView imageView, String image);

  void loadImage(ImageView imageView, String image, String imageThumbnail);

  void loadImage(ImageView imageView, String image, int placeHolderId, int errorId);

  void loadImage(ImageView imageView, String image, String thumbnail, int placeHolderId, int errorId);

  // Load with intRes
  void loadImage(ImageView imageView, int imageResId);

  void loadImage(ImageView imageView, int imageResId, int placeHolderId, int errorId);

  // Load with Uri
  void loadImage(ImageView imageView, Uri uri);

  void loadImage(ImageView imageView, Uri uri, int placeHolderId, int errorId);

  RequestBuilder<Drawable> getRequestBuilder(ImageView imageView, ImageLoaderGlide.LOAD_TYPE loadType, String image, int imageResId, Uri uri, String thumbnail, int placeHolderId, int errorId);

  void pauseLoad(Context context);

  void resumeLoad(Context context);

  default boolean isValid(ImageView imageView) {
    return imageView != null && (ContextUtils.isValidContext(imageView.getContext()));
  }
}

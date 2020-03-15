package com.returnnotfound.stain.widget.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class ImageLoaderGlide implements ImageLoader {

  @Override
  public RequestBuilder<Drawable> getRequestBuilderDefault(ImageView imageView) {
    return getRequestBuilder(imageView, LOAD_TYPE.INT, null, DEFAULT_PLACE_HOLDER, null, null, DEFAULT_PLACE_HOLDER, DEFAULT_PLACE_HOLDER);
  }

  // Load with String
  @Override
  public void loadImage(ImageView imageView, String image) {
    loadImage(imageView, image, null);
  }

  @Override
  public void loadImage(ImageView imageView, String image, String imageThumbnail) {
    loadImage(imageView, image, imageThumbnail, DEFAULT_PLACE_HOLDER, DEFAULT_PLACE_HOLDER);
  }

  @Override
  public void loadImage(ImageView imageView, String image, int placeHolderId, int errorId) {
    loadImage(imageView, image, null, placeHolderId, errorId);
  }

  @Override
  public void loadImage(ImageView imageView, String image, String thumbnail, int placeHolderId, int errorId) {
    loadImage(imageView, LOAD_TYPE.STRING, image, DEFAULT_PLACE_HOLDER, null, thumbnail, placeHolderId, errorId);
  }


  // Load with intRes
  @Override
  public void loadImage(ImageView imageView, int imageResId) {
    loadImage(imageView, imageResId, DEFAULT_PLACE_HOLDER, DEFAULT_PLACE_HOLDER);
  }

  @Override
  public void loadImage(ImageView imageView, int imageResId, int placeHolderId, int errorId) {
    loadImage(imageView, LOAD_TYPE.INT, null, imageResId, null, null, placeHolderId, errorId);
  }

  // Load with Uri
  @Override
  public void loadImage(ImageView imageView, Uri uri) {
    loadImage(imageView, uri, DEFAULT_PLACE_HOLDER, DEFAULT_PLACE_HOLDER);
  }

  @Override
  public void loadImage(ImageView imageView, Uri uri, int placeHolderId, int errorId) {
    loadImage(imageView, LOAD_TYPE.URI, null, DEFAULT_PLACE_HOLDER, uri, null, placeHolderId, errorId);
  }


  // Load base
  public void loadImage(ImageView imageView, LOAD_TYPE loadType, String image, int imageResId, Uri uri, String thumbnail, int placeHolderId, int errorId) {
    if (!isValid(imageView)) {
      return;
    }
    getRequestBuilder(imageView, loadType, image, imageResId, uri, thumbnail, placeHolderId, errorId).into(imageView);
  }

  public RequestBuilder<Drawable> getRequestBuilder(ImageView imageView, LOAD_TYPE loadType, String image, int imageResId, Uri uri, String thumbnail, int placeHolderId, int errorId) {
    RequestManager requestManager = Glide.with(imageView);
    RequestBuilder<Drawable> requestBuilder;
    switch (loadType) {
      case INT:
        requestBuilder = requestManager.load(uri);
        break;
      case URI:
        requestBuilder = requestManager.load(imageResId);
        break;
      case STRING:
        requestBuilder = requestManager.load(image);
        break;
      default:
        requestBuilder = requestManager.load("");
        break;
    }
    requestBuilder = requestBuilder
        .thumbnail(0.5f)
        .placeholder(placeHolderId)
        .error(errorId)
        .transition(withCrossFade());

    if (thumbnail != null) {
      requestBuilder = requestBuilder.thumbnail(Glide.with(imageView).load(thumbnail));
    }

    return requestBuilder;
  }

  @Override
  public void pauseLoad(Context context) {
    Glide.with(context).pauseRequests();
  }

  @Override
  public void resumeLoad(Context context) {
    Glide.with(context).resumeRequests();
  }

  public enum LOAD_TYPE {
    STRING, INT, URI
  }
}

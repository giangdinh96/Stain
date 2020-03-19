package com.returnnotfound.stain.widget.image

import android.content.Context
import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class ImageLoaderGlide : ImageLoader {
  override fun getRequestBuilderDefault(imageView: ImageView?): RequestBuilder<Drawable?>? {
    return getRequestBuilder()
  }

  override fun loadImage(
    imageView: ImageView?,
    url: String?,
    resId: Int,
    uri: Uri?,
    thumbnail: String?,
    placeHolderId: Int,
    errorId: Int
  ) {
    if (!isValid(imageView)) {
      return
    }
    getRequestBuilder(
      imageView,
      url, resId, uri,
      thumbnail, placeHolderId, errorId
    )?.into(imageView!!)
  }

  override fun getRequestBuilder(
    imageView: ImageView?,
    url: String?,
    resId: Int,
    uri: Uri?,
    thumbnail: String?,
    placeHolderId: Int,
    errorId: Int
  ): RequestBuilder<Drawable?>? {
    val requestManager = Glide.with(imageView!!)
    var requestBuilder: RequestBuilder<Drawable?>
    requestBuilder = when {
      uri != null -> requestManager.load(uri)
      url != null -> requestManager.load(url)
      else -> requestManager.load(resId)
    }
    requestBuilder = requestBuilder
      .thumbnail(0.5f)
      .placeholder(placeHolderId)
      .error(errorId)
      .transition(DrawableTransitionOptions.withCrossFade())
    if (thumbnail != null) {
      requestBuilder = requestBuilder.thumbnail(Glide.with(imageView).load(thumbnail))
    }
    return requestBuilder
  }

  override fun pauseLoad(context: Context?) {
    context?.let { Glide.with(it).pauseRequests() }
  }

  override fun resumeLoad(context: Context?) {
    context?.let { Glide.with(it).resumeRequests() }
  }
}
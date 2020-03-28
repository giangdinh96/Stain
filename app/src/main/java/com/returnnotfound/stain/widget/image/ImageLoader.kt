package com.returnnotfound.stain.widget.image

import android.content.Context
import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.RequestBuilder
import com.returnnotfound.stain.App
import com.returnnotfound.stain.R
import com.returnnotfound.stain.utils.ContextUtils

interface ImageLoader {
  fun getRequestBuilderDefault(imageView: ImageView?): RequestBuilder<Drawable?>?

  fun loadImage(
    imageView: ImageView? = null,
    url: String? = null,
    resId: Int = DEFAULT_PLACE_HOLDER,
    uri: Uri? = null,
    thumbnail: String? = null,
    placeHolderId: Int = DEFAULT_PLACE_HOLDER,
    errorId: Int = DEFAULT_PLACE_HOLDER
  )

  fun getRequestBuilder(
    imageView: ImageView? = null,
    url: String? = null,
    resId: Int = DEFAULT_PLACE_HOLDER,
    uri: Uri? = null,
    thumbnail: String? = null,
    placeHolderId: Int = DEFAULT_PLACE_HOLDER,
    errorId: Int = DEFAULT_PLACE_HOLDER
  ): RequestBuilder<Drawable?>?

  fun pauseLoad(context: Context?)

  fun resumeLoad(context: Context?)

  fun isValid(imageView: ImageView?) =
    imageView != null && ContextUtils.isValidContext(imageView.context)

  companion object {
    const val FILE_EXTENSION = ".JPG"
    const val DEFAULT_PLACE_HOLDER = R.drawable.image_placeholder
    val CACHE_PATH: String = App.instance!!.cacheDir.absolutePath
  }
}
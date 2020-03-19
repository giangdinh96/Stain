package com.returnnotfound.stain.widget.image

object ImageLoaderFactory {
  private val DEFAULT = Type.GLIDE
  private val sGlideInstance: ImageLoader = ImageLoaderGlide()
  val instance: ImageLoader get() = getInstance(DEFAULT)

  private fun getInstance(type: Type?): ImageLoader {
    return when (type) {
      Type.GLIDE -> sGlideInstance
      else -> sGlideInstance
    }
  }

  enum class Type {
    GLIDE, PICASSO
  }
}
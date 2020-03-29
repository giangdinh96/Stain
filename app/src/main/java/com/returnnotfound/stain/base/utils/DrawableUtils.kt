package com.returnnotfound.stain.base.utils

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable

object DrawableUtils {
  @JvmStatic
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
package com.returnnotfound.stain.utils

import android.app.Activity
import android.content.Context

object ContextUtils {
  fun isValidContext(context: Context?): Boolean {
    // Context null
    return if (context == null) {
      false
    } else context !is Activity || !context.isFinishing
    // Activity is finishing
  }
}
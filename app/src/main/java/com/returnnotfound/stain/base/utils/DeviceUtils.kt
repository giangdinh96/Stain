package com.returnnotfound.stain.base.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.provider.Settings

object DeviceUtils {
  @JvmStatic
  fun isLandscape(activity: Activity): Boolean {
    return activity.resources
      .configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
  }

  @JvmStatic
  fun isActivityAutoRotate(activity: Activity): Boolean {
    return activity.resources
      .configuration.orientation == Configuration.ORIENTATION_UNDEFINED
  }

  @SuppressLint("SourceLockedOrientationActivity")
  @JvmStatic
  fun forceRotateScreen(activity: Activity, orientation: Int) {
    when (orientation) {
      Configuration.ORIENTATION_LANDSCAPE -> activity.requestedOrientation =
        ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
      Configuration.ORIENTATION_PORTRAIT -> activity.requestedOrientation =
        ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
      Configuration.ORIENTATION_UNDEFINED -> activity.requestedOrientation =
        ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
    }
  }

  @JvmStatic
  fun isDeviceLockRotate(context: Context): Boolean {
    val rotationState =
      Settings.System.getInt(context.contentResolver, Settings.System.ACCELEROMETER_ROTATION, 0)
    return rotationState == 0
  }
}
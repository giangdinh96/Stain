package com.returnnotfound.stain.base.utils

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri

object AppUtils {

  @JvmStatic
  fun openAppInStore(context: Context) {
    val appPackageName = context.packageName
    try {
      context.startActivity(
        Intent(
          Intent.ACTION_VIEW,
          Uri.parse("market://details?id=$appPackageName")
        )
      )
    } catch (e: ActivityNotFoundException) {
      context.startActivity(
        Intent(
          Intent.ACTION_VIEW,
          Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")
        )
      )
    }
  }
}
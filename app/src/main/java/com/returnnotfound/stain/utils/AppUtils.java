package com.returnnotfound.stain.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public abstract class AppUtils {
  public static void openAppInStore(Context context) {
    final String appPackageName = context.getPackageName();
    try {
      context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
    } catch (android.content.ActivityNotFoundException e) {
      context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
    }
  }
}

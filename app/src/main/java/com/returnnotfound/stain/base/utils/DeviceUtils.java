package com.returnnotfound.stain.base.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.provider.Settings;

public abstract class DeviceUtils {
  public static boolean isLandscape(Activity activity) {
    return activity.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
  }

  public static boolean isActivityAutoRotate(Activity activity) {
    return activity.getResources().getConfiguration().orientation == Configuration.ORIENTATION_UNDEFINED;
  }

  @SuppressLint("SourceLockedOrientationActivity")
  public static void forceRotateScreen(Activity activity, int orientation) {
    switch (orientation) {
      case Configuration.ORIENTATION_LANDSCAPE:
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        break;
      case Configuration.ORIENTATION_PORTRAIT:
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        break;
      case Configuration.ORIENTATION_UNDEFINED:
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        break;
    }
  }

  public static boolean isDeviceLockRotate(Context context) {
    final int rotationState = Settings.System.getInt(
        context.getContentResolver(),
        Settings.System.ACCELEROMETER_ROTATION, 0
    );

    return rotationState == 0;
  }
}

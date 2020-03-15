package com.returnnotfound.stain.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public abstract class DimensionUtils {
  public static int dpToPx(Context context, float dp) {
    return (int) (dp * ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT));
  }

  public static float pxToDp(Context context, float px) {
    if (context == null || context.getResources() == null) {
      return 0;
    }
    return px / ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
  }

  public static float getWidthScreenDp(Context context) {
    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
    return displayMetrics.widthPixels / displayMetrics.density;
  }

  public static float getHeightScreenDp(Context context) {
    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
    return displayMetrics.heightPixels / displayMetrics.density;
  }

  public static int getStatusBarHeight(Context context) {
    int result = 0;
    int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (resourceId > 0) {
      result = context.getResources().getDimensionPixelSize(resourceId);
    }
    return result;
  }

  public static int getActionBarHeight(Context context) {
    TypedValue tv = new TypedValue();
    if (context.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
      return TypedValue.complexToDimensionPixelSize(tv.data, context.getResources().getDisplayMetrics());
    }
    return 0;
  }
}

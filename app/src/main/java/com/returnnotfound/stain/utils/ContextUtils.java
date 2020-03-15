package com.returnnotfound.stain.utils;

import android.app.Activity;
import android.content.Context;

public abstract class ContextUtils {

  public static boolean isValidContext(Context context) {
    // Context null
    if (context == null) {
      return false;
    }
    // Activity is finishing
    return !(context instanceof Activity) || !((Activity) context).isFinishing();
  }
}

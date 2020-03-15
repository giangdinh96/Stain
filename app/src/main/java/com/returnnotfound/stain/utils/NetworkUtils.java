package com.returnnotfound.stain.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtils {

  public static boolean isNetworkAvailable(Context context, boolean shouldShowPopup) {
    boolean isCon = isOnline(context);
    if (!isCon && shouldShowPopup) {
      //
    }
    return isCon;
  }

  public static boolean isNoNetworkAvailable(Context context, boolean shouldShowPopup) {
    return !isNetworkAvailable(context, shouldShowPopup);
  }

  public static boolean isOnline(Context context) {
    ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    if (cm == null) {
      return false;
    }
    NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
    return activeNetwork != null && activeNetwork.isConnected();
  }

  public static boolean is3GOn(Context context) {
    ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    if (cm == null) {
      return false;
    }
    NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
    if (activeNetwork != null) { // connected to the internet
      if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
        // connected to wifi
        return false;
      } else return activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE;
    }
    // not connected to the internet
    return false;
  }
}

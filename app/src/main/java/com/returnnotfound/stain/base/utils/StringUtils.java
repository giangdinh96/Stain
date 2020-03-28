package com.returnnotfound.stain.base.utils;

import android.util.Patterns;
import android.webkit.URLUtil;

import java.util.regex.Pattern;

import static com.returnnotfound.stain.base.CoreDefaultKt.STRING_EMPTY;

/**
 * String Utils
 */
public abstract class StringUtils {
  public static boolean isNull(String value) {
    return value == null;
  }

  public static boolean isEmpty(String value) {
    return value != null && value.isEmpty();
  }

  public static boolean isNullOrEmpty(String value) {
    return value == null || value.isEmpty();
  }

  public static boolean isNotEmpty(String value) {
    return value != null && !value.isEmpty();
  }

  public static String capitalizeFirstLetter(String original) {
    if (original == null || original.length() == 0) {
      return STRING_EMPTY;
    }
    return original.substring(0, 1).toUpperCase() + original.substring(1).toLowerCase();
  }

  public static boolean equalsIgnoreCase(String s1, String s2) {
    return s1 != null && s1.equalsIgnoreCase(s2);
  }

  public static boolean isEmail(String email) {
    Pattern pattern = Patterns.EMAIL_ADDRESS;
    return !isNullOrEmpty(email) && pattern.matcher(email).matches();
  }

  public static boolean isPhone(String phone) {
    Pattern pattern = Patterns.PHONE;
    return !isNullOrEmpty(phone) && pattern.matcher(phone).matches();
  }

  public static boolean isUrlLink(String url) {
    if (isNullOrEmpty(url))
      return false;
    return URLUtil.isValidUrl(url);
  }

  public static String formatUrl(String url) {
    if (url == null) return STRING_EMPTY;
    if (url.startsWith("http")) {
      return url;
    }
    return "http://" + url;
  }
}

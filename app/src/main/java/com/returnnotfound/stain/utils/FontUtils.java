package com.returnnotfound.stain.utils;


import android.content.Context;
import android.graphics.Typeface;

import java.util.Hashtable;

public abstract class FontUtils {

  private static final Hashtable<String, Typeface> CACHE = new Hashtable<>();

  public static Typeface get(Context c, String font) {
    synchronized (CACHE) {
      if (!CACHE.containsKey(font)) {
        try {
          String path = "fonts/" + font;
          Typeface t = Typeface.createFromAsset(c.getAssets(), path);
          CACHE.put(font, t);
        } catch (Exception e) {
          return null;
        }
      }
      return CACHE.get(font);
    }
  }
}

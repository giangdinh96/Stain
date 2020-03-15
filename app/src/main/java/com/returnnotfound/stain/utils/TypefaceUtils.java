package com.returnnotfound.stain.utils;

import android.content.res.AssetManager;
import android.graphics.Typeface;

public class TypefaceUtils {
  public static Typeface load(final AssetManager assetManager, final String filePath) {
    return io.github.inflationx.calligraphy3.TypefaceUtils.load(assetManager, filePath);
  }
}

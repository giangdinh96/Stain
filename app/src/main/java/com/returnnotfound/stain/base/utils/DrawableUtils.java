package com.returnnotfound.stain.base.utils;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

public class DrawableUtils {
  public static Drawable getDrawable(int radius, String color) {
    GradientDrawable gradientDrawable = new GradientDrawable();
    gradientDrawable.setCornerRadius(radius);
    try {
      gradientDrawable.setColor(Color.parseColor(color));
    } catch (Exception e) {
      gradientDrawable.setColor(Color.parseColor("#de4242"));
    }
    return gradientDrawable;
  }
}

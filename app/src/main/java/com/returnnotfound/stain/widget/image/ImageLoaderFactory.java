package com.returnnotfound.stain.widget.image;

public class ImageLoaderFactory {
  private static final Type DEFAULT = Type.GLIDE;

  private static ImageLoader sGlideInstance = new ImageLoaderGlide();

  public static ImageLoader getInstance() {
    return getInstance(DEFAULT);
  }

  public static ImageLoader getInstance(Type type) {
    switch (type) {
      case GLIDE:
      default:
        return sGlideInstance;
    }
  }

  public enum Type {
    GLIDE, PICASSO
  }
}
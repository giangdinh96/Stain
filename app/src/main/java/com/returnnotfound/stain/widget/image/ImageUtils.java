package com.returnnotfound.stain.widget.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;

import com.bumptech.glide.RequestBuilder;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.returnnotfound.stain.widget.image.ImageLoader.CACHE_PATH;
import static com.returnnotfound.stain.widget.image.ImageLoader.FILE_EXTENSION;

public class ImageUtils {

  public static RequestBuilder<Drawable> getRequestBuilderDefault(ImageView imageView) {
    return ImageLoaderFactory.getInstance().getRequestBuilderDefault(imageView);
  }

  // Load with String
  public static void loadImage(ImageView imageView, String image) {
    ImageLoaderFactory.getInstance().loadImage(imageView, image);
  }

  public static void loadImage(ImageView imageView, String image, String imageThumbnail) {
    ImageLoaderFactory.getInstance().loadImage(imageView, image, imageThumbnail);
  }

  public static void loadImage(ImageView imageView, String image, int placeHolderId, int errorId) {
    ImageLoaderFactory.getInstance().loadImage(imageView, image, placeHolderId, errorId);
  }

  public static void loadImage(ImageView imageView, String image, String thumbnail, int placeHolderId, int errorId) {
    ImageLoaderFactory.getInstance().loadImage(imageView, image, thumbnail, placeHolderId, errorId);
  }

  // Load with int
  public static void loadImage(ImageView imageView, @DrawableRes int imageResId) {
    ImageLoaderFactory.getInstance().loadImage(imageView, imageResId);
  }

  public static void loadImage(ImageView imageView, @DrawableRes int imageResId, int placeHolderId, int errorId) {
    ImageLoaderFactory.getInstance().loadImage(imageView, imageResId, placeHolderId, errorId);
  }

  // Load with uri
  public static void loadImage(ImageView imageView, Uri uri) {
    ImageLoaderFactory.getInstance().loadImage(imageView, uri);
  }

  public static void loadImage(ImageView imageView, Uri uri, int placeHolderId, int errorId) {
    ImageLoaderFactory.getInstance().loadImage(imageView, uri, placeHolderId, errorId);
  }

  // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------//

  public static void pauseLoad(Context context) {
    ImageLoaderFactory.getInstance().pauseLoad(context);
  }

  public static void resumeLoad(Context context) {
    ImageLoaderFactory.getInstance().resumeLoad(context);
  }

  public static Bitmap getBitmapFromLocal(String path) {
    final BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = false;
    return BitmapFactory.decodeFile(path, options);
  }

  public static Bitmap getBitmapFromLocal(String path, BitmapFactory.Options options) {
    return BitmapFactory.decodeFile(path, options);
  }

  public static String saveBitmap(Bitmap data) {
    String imageName = System.currentTimeMillis() + FILE_EXTENSION;
    String pathImage = CACHE_PATH + imageName;
    saveBitmap(data, pathImage);
    return pathImage;
  }

  public static boolean saveBitmap(Bitmap bitmap, String file) {
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
    File f = new File(file);
    try {
      if (!f.exists()) {
        f.createNewFile();
      }
      // write the bytes in file
      FileOutputStream fo = new FileOutputStream(f);
      fo.write(bytes.toByteArray());

      // remember close de FileOutput
      fo.close();
      bitmap.recycle();
      bitmap = null;
      return true;
    } catch (IOException e) {
      bitmap.recycle();
      return false;
    }
  }

  private static Bitmap rotateImage(Bitmap bitmap, int rotate) {
    Bitmap rotateBitmap;
    if (rotate > 0) {
      Matrix matrix = new Matrix();
      matrix.postRotate(rotate);
      rotateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    } else {
      rotateBitmap = bitmap;
    }
    return rotateBitmap;
  }

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

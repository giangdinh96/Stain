/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.returnnotfound.stain.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

import androidx.fragment.app.Fragment;

import com.returnnotfound.stain.Anim;

import static com.returnnotfound.stain.CoreDefaultKt.ANIM_START_ACTIVITY_DEFAULT;
import static com.returnnotfound.stain.CoreDefaultKt.FLAG_CLEAR_TASK;
import static com.returnnotfound.stain.CoreDefaultKt.FLAG_CLEAR_TOP;
import static com.returnnotfound.stain.CoreDefaultKt.FLAG_DEFAULT;

/**
 * This provides methods to help Activities load their UI.
 */
public abstract class ActivityUtils {

  // Start activity normal
  public static <T extends Activity> void startActivity(Context context, Class<T> clazz) {
    startActivity(context, clazz, null, ANIM_START_ACTIVITY_DEFAULT);
  }

  public static <T extends Activity> void startActivity(Context context, Class<T> clazz, Bundle extras) {
    startActivity(context, clazz, extras, ANIM_START_ACTIVITY_DEFAULT);
  }

  public static <T extends Activity> void startActivity(Context context, Class<T> clazz, Anim anim) {
    startActivity(context, clazz, null, anim);
  }

  public static <T extends Activity> void startActivity(Context context, Class<T> clazz, Bundle extras, Anim anim) {
    startActivity(context, clazz, extras, anim, FLAG_DEFAULT);
  }


  // Start activity clear top
  public static <T extends Activity> void startActivityClearTop(Context context, Class<T> clazz) {
    startActivityClearTop(context, clazz, null, ANIM_START_ACTIVITY_DEFAULT);
  }

  public static <T extends Activity> void startActivityClearTop(Context context, Class<T> clazz, Bundle extras) {
    startActivityClearTop(context, clazz, extras, ANIM_START_ACTIVITY_DEFAULT);
  }

  public static <T extends Activity> void startActivityClearTop(Context context, Class<T> clazz, Anim anim) {
    startActivityClearTop(context, clazz, null, anim);
  }

  public static <T extends Activity> void startActivityClearTop(Context context, Class<T> clazz, Bundle extras, Anim anim) {
    startActivity(context, clazz, extras, anim, FLAG_CLEAR_TOP);
  }


  // Start activity clear task
  public static <T extends Activity> void startActivityClearTask(Context context, Class<T> clazz) {
    startActivityClearTask(context, clazz, null, ANIM_START_ACTIVITY_DEFAULT);
  }

  public static <T extends Activity> void startActivityClearTask(Context context, Class<T> clazz, Bundle extras) {
    startActivityClearTask(context, clazz, extras, ANIM_START_ACTIVITY_DEFAULT);
  }

  public static <T extends Activity> void startActivityClearTask(Context context, Class<T> clazz, Anim anim) {
    startActivityClearTask(context, clazz, null, anim);
  }

  public static <T extends Activity> void startActivityClearTask(Context context, Class<T> clazz, Bundle extras, Anim anim) {
    startActivity(context, clazz, extras, anim, FLAG_CLEAR_TASK);
  }


  // Start activity for result with activity
  public static <T extends Activity> void startActivityForResult(Activity activity, Class<T> clazz, int requestCode) {
    startActivityForResult(activity, clazz, null, ANIM_START_ACTIVITY_DEFAULT, requestCode);
  }

  public static <T extends Activity> void startActivityForResult(Activity activity, Class<T> clazz, Bundle extras, int requestCode) {
    startActivityForResult(activity, clazz, extras, ANIM_START_ACTIVITY_DEFAULT, requestCode);
  }

  public static <T extends Activity> void startActivityForResult(Activity activity, Class<T> clazz, Anim anim, int requestCode) {
    startActivityForResult(activity, clazz, null, anim, requestCode);
  }

  public static <T extends Activity> void startActivityForResult(Activity activity, Class<T> clazz, Bundle extras, Anim anim, int requestCode) {
    startActivity(activity, clazz, extras, anim, FLAG_DEFAULT, true, requestCode);
  }

  // Start activity for result with fragment
  public static <T extends Activity> void startActivityForResult(Fragment fragment, Class<T> clazz, int requestCode) {
    startActivityForResult(fragment, clazz, null, ANIM_START_ACTIVITY_DEFAULT, requestCode);
  }

  public static <T extends Activity> void startActivityForResult(Fragment fragment, Class<T> clazz, Bundle extras, int requestCode) {
    startActivityForResult(fragment, clazz, extras, ANIM_START_ACTIVITY_DEFAULT, requestCode);
  }

  public static <T extends Activity> void startActivityForResult(Fragment fragment, Class<T> clazz, Anim anim, int requestCode) {
    startActivityForResult(fragment, clazz, null, anim, requestCode);
  }

  public static <T extends Activity> void startActivityForResult(Fragment fragment, Class<T> clazz, Bundle extras, Anim anim, int requestCode) {
    startActivity(fragment, clazz, extras, anim, FLAG_DEFAULT, true, requestCode);
  }


  public static <T extends Activity> void startActivity(Context context, Class<T> clazz, Bundle data, Anim anim, int flag) {
    Intent intent = new Intent(context, clazz);
    if (data != null) {
      intent.putExtras(data);
    }
    if (flag != -1) {
      intent.setFlags(flag);
    }
    context.startActivity(intent);
    overrideTransition(context, anim);
  }

  public static <T extends Activity> void startActivity(Activity activity, Class<T> clazz, Bundle data, Anim anim, int flag, boolean isForResult, int requestCode) {
    Intent intent = new Intent(activity, clazz);
    if (data != null) {
      intent.putExtras(data);
    }
    if (flag != -1) {
      intent.setFlags(flag);
    }
    if (isForResult) {
      activity.startActivityForResult(intent, requestCode);
    } else {
      activity.startActivity(intent);
    }
    overrideTransition(activity, anim);
  }

  public static <T extends Activity> void startActivity(Fragment fragment, Class<T> clazz, Bundle data, Anim anim, int flag, boolean isForResult, int requestCode) {
    Context context = fragment.getContext();
    Intent intent = new Intent(context, clazz);
    if (data != null) {
      intent.putExtras(data);
    }
    if (flag != -1) {
      intent.setFlags(flag);
    }
    if (isForResult) {
      fragment.startActivityForResult(intent, requestCode);
    } else {
      fragment.startActivity(intent);
    }
    overrideTransition(context, anim);
  }

  // Support method
  private static void overrideTransition(Context context, Anim anim) {
    if (context instanceof Activity) {
      ((Activity) context).overridePendingTransition(anim.getEnter(), anim.getExit());
    }
  }

  // Start activity special
  public static void startPlayVideo(Context context, String url) {
    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
    intent.setDataAndType(Uri.parse(url), "video/*");
    intent.putExtra(MediaStore.EXTRA_FINISH_ON_COMPLETION, false);
    context.startActivity(intent);
  }
}

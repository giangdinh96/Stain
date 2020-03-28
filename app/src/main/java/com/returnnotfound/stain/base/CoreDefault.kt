package com.returnnotfound.stain.base

import android.content.Intent
import com.returnnotfound.stain.R

// Id
const val ROOT_LAYOUT_ID = R.layout.activity_base
const val FRAGMENT_CONTAINER_ID = R.id.container_id


// Flag to start activity
const val FLAG_CLEAR_TASK = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
const val FLAG_CLEAR_TOP = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
const val FLAG_DEFAULT = -1


// Anim for start activity
@JvmField
val ANIM_START_ACTIVITY_DEFAULT = Anim.SLIDE_RIGHT_TO_LEFT


// Anim
const val ANIM_ENTER_RIGHT_TO_LEFT = R.anim.anim_enter_right_to_left
const val ANIM_EXIT_RIGHT_TO_LEFT = R.anim.anim_exit_right_to_left
const val ANIM_ENTER_LEFT_TO_RIGHT = R.anim.anim_enter_left_to_right
const val ANIM_EXIT_LEFT_TO_RIGHT = R.anim.anim_exit_left_to_right
const val ANIM_NONE = R.anim.anim_none


// Resource
const val STRING_EMPTY = ""


// Font default
const val FONT_DEFAULT_PATH = "fonts/BeVietnam-Regular.ttf"


// MimeType - Type
const val TYPE_VIDEO = "video"
const val TYPE_IMAGE = "image"


// MimeType - Subtype
const val MIME_TYPE_VIDEO_MP4 = "video/mp4"
const val MIME_TYPE_VIDEO_MOV = "video/mov"
const val MIME_TYPE_IMAGE_PNG = "image/png"
const val MIME_TYPE_IMAGE_JPEG = "image/jpeg"

@JvmField
val COLOR_REFRESH_PROGRESS = intArrayOf(
  android.R.color.holo_red_light,
  android.R.color.holo_blue_light,
  android.R.color.holo_green_light,
  android.R.color.holo_orange_light
)

enum class Anim(var enter: Int, var exit: Int) {
  SLIDE_RIGHT_TO_LEFT(ANIM_ENTER_RIGHT_TO_LEFT, ANIM_EXIT_RIGHT_TO_LEFT),
  SLIDE_LEFT_TO_RIGHT(ANIM_ENTER_LEFT_TO_RIGHT, ANIM_EXIT_LEFT_TO_RIGHT),
  SLIDE_NONE(ANIM_NONE, ANIM_NONE);
}
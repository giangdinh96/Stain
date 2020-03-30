package com.returnnotfound.stain.base.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.returnnotfound.stain.base.extension.loadImage
import com.returnnotfound.stain.base.extension.loadImageCircle
import com.returnnotfound.stain.base.extension.loadImageRound

@BindingAdapter("android:url", "android:circle", "android:corner", requireAll = false)
fun setImage(imageView: ImageView, url: String, circle: Boolean, corner: Float) {
  if (circle) {
    imageView.loadImageCircle(url)
  } else {
    if (corner > 0) {
      imageView.loadImageRound(corner.toInt(), url)
    } else {
      imageView.loadImage(url)
    }
  }
}
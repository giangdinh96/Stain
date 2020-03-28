package com.returnnotfound.stain.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.returnnotfound.stain.R
import com.returnnotfound.stain.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding = DataBindingUtil.setContentView<ActivityTestBinding>(this, R.layout.activity_test)

  }
}
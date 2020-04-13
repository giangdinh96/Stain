package com.returnnotfound.stain.presentation.ui.main

import android.view.View

interface MainView {
  fun onMenuClick(view: View?)
  fun onNotificationClick(view: View?)
  fun initMenuAnimation()
  fun initMainPager()
}
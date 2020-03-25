package com.returnnotfound.stain.presentation.ui.main;

import android.view.View;

public interface MainView {
  void onMenuClick(View view);

  void onNotificationClick(View view);

  void initMenuAnimation();

  void initMainPager();
}
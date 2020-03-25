package com.returnnotfound.stain.presentation.ui.main;

import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.returnnotfound.stain.R;

public abstract class MainViewPagerConnection {
  public static BottomNavigationView.OnNavigationItemSelectedListener connect(ViewPager2 viewPager) {
    return item -> {
      switch (item.getItemId()) {
        case R.id.discover_mn:
          viewPager.setCurrentItem(0);
          break;
        case R.id.rank_mn:
          viewPager.setCurrentItem(1);
          break;
        case R.id.love_mn:
          viewPager.setCurrentItem(2);
          break;
      }
      return true;
    };
  }
}

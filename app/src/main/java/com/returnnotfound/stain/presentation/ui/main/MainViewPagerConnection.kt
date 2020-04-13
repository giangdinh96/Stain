package com.returnnotfound.stain.presentation.ui.main

import android.view.MenuItem
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.returnnotfound.stain.R

object MainViewPagerConnection {
  @JvmStatic
  fun connect(viewPager: ViewPager2): BottomNavigationView.OnNavigationItemSelectedListener {
    return BottomNavigationView.OnNavigationItemSelectedListener { item: MenuItem ->
      when (item.itemId) {
        R.id.discover_mn -> viewPager.currentItem = 0
        R.id.rank_mn -> viewPager.currentItem = 1
        R.id.love_mn -> viewPager.currentItem = 2
      }
      true
    }
  }
}
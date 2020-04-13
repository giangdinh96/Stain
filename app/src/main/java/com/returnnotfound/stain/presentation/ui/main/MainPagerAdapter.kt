package com.returnnotfound.stain.presentation.ui.main

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.returnnotfound.stain.presentation.ui.main.discover.DiscoverFragment.Companion.newInstance
import com.returnnotfound.stain.presentation.ui.main.love.LoveFragment
import com.returnnotfound.stain.presentation.ui.main.rank.RankFragment

class MainPagerAdapter(fragment: Fragment) :
  FragmentStateAdapter(fragment) {
  private val fragments =
    arrayOf<Fragment>(
      newInstance(),
      RankFragment.newInstance(),
      LoveFragment.newInstance()
    )

  override fun createFragment(position: Int): Fragment {
    return fragments[position]
  }

  override fun getItemCount(): Int {
    return fragments.size
  }
}
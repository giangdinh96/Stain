package com.returnnotfound.stain.presentation.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.returnnotfound.stain.presentation.main.discover.DiscoverFragment;
import com.returnnotfound.stain.presentation.main.love.LoveFragment;
import com.returnnotfound.stain.presentation.main.rank.RankFragment;

public class MainPagerAdapter extends FragmentStateAdapter {
  private Fragment[] fragments = new Fragment[]{DiscoverFragment.newInstance(), RankFragment.newInstance(), LoveFragment.newInstance()};

  public MainPagerAdapter(@NonNull Fragment fragment) {
    super(fragment);
  }

  @NonNull
  @Override
  public Fragment createFragment(int position) {
    return fragments[position];
  }

  @Override
  public int getItemCount() {
    return fragments.length;
  }
}

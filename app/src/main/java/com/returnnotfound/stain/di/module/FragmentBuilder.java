package com.returnnotfound.stain.di.module;

import com.returnnotfound.stain.ui.main.MainFragment;
import com.returnnotfound.stain.ui.main.discover.DiscoverFragment;
import com.returnnotfound.stain.ui.main.love.LoveFragment;
import com.returnnotfound.stain.ui.main.rank.RankFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuilder {

  @ContributesAndroidInjector
  abstract MainFragment contributeMainFragment();

  @ContributesAndroidInjector
  abstract DiscoverFragment contributesDiscoverFragment();

  @ContributesAndroidInjector
  abstract RankFragment contributesRankFragment();

  @ContributesAndroidInjector
  abstract LoveFragment contributesLoveFragment();
}

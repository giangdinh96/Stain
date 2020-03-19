package com.returnnotfound.stain.di.module

import com.returnnotfound.stain.presentation.main.MainFragment
import com.returnnotfound.stain.presentation.main.discover.DiscoverFragment
import com.returnnotfound.stain.presentation.main.love.LoveFragment
import com.returnnotfound.stain.presentation.main.rank.RankFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {
  @ContributesAndroidInjector
  abstract fun contributeMainFragment(): MainFragment

  @ContributesAndroidInjector
  abstract fun contributesDiscoverFragment(): DiscoverFragment

  @ContributesAndroidInjector
  abstract fun contributesRankFragment(): RankFragment

  @ContributesAndroidInjector
  abstract fun contributesLoveFragment(): LoveFragment
}
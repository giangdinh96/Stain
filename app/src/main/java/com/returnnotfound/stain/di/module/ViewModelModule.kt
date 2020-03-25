package com.returnnotfound.stain.di.module

import androidx.lifecycle.ViewModel
import com.returnnotfound.stain.di.ViewModelKey
import com.returnnotfound.stain.presentation.ui.main.discover.DiscoverViewModel
import com.returnnotfound.stain.presentation.ui.main.rank.RankViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

  @ViewModelKey(DiscoverViewModel::class)
  @IntoMap
  @Binds
  abstract fun bindDiscoverViewModel(discoverViewModel: DiscoverViewModel): ViewModel

  @ViewModelKey(RankViewModel::class)
  @IntoMap
  @Binds
  abstract fun bindRankViewModel(rankViewModel: RankViewModel): ViewModel
}
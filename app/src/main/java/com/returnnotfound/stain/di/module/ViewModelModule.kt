package com.returnnotfound.stain.di.module

import androidx.lifecycle.ViewModel
import com.returnnotfound.stain.di.ViewModelKey
import com.returnnotfound.stain.presentation.main.rank.RankViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

  @ViewModelKey(RankViewModel::class)
  @IntoMap
  @Binds
  abstract fun bindRankVM(rankVM: RankViewModel): ViewModel
}
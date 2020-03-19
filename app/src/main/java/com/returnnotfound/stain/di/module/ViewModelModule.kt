package com.returnnotfound.stain.di.module

import androidx.lifecycle.ViewModel
import com.returnnotfound.stain.di.ViewModelKey
import com.returnnotfound.stain.presentation.main.rank.RankVMImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

  @ViewModelKey(RankVMImpl::class)
  @IntoMap
  @Binds
  abstract fun bindRankVM(rankVMImpl: RankVMImpl): ViewModel
}
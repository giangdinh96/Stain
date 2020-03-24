package com.returnnotfound.stain.di.module

import com.returnnotfound.stain.data.source.BannerLocalSource
import com.returnnotfound.stain.data.source.BannerLocalSourceImpl
import com.returnnotfound.stain.data.source.BannerRemoteSource
import com.returnnotfound.stain.data.source.BannerRemoteSourceImpl
import dagger.Binds
import dagger.Module

@Module
abstract class DataSourceModule {
  @Binds
  abstract fun bindBannerLocalSource(bannerLocalSourceImpl: BannerLocalSourceImpl): BannerLocalSource

  @Binds
  abstract fun bindBannerRemoteSource(bannerRemoteSourceImpl: BannerRemoteSourceImpl): BannerRemoteSource
}
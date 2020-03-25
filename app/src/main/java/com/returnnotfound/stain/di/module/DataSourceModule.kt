package com.returnnotfound.stain.di.module

import com.returnnotfound.stain.data.repository.source.BannerLocalSource
import com.returnnotfound.stain.data.repository.source.BannerLocalSourceImpl
import com.returnnotfound.stain.data.repository.source.BannerRemoteSource
import com.returnnotfound.stain.data.repository.source.BannerRemoteSourceImpl
import dagger.Binds
import dagger.Module

@Module
abstract class DataSourceModule {
  @Binds
  abstract fun bindBannerLocalSource(bannerLocalSourceImpl: BannerLocalSourceImpl): BannerLocalSource

  @Binds
  abstract fun bindBannerRemoteSource(bannerRemoteSourceImpl: BannerRemoteSourceImpl): BannerRemoteSource
}
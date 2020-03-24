package com.returnnotfound.stain.di.module

import com.returnnotfound.stain.data.repository.BannerRepositoryImpl
import com.returnnotfound.stain.domain.repository.BannerRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
  @Binds
  abstract fun bindBannerRepository(bannerRepositoryImpl: BannerRepositoryImpl): BannerRepository
}
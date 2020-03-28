package com.returnnotfound.stain.data.repository

import com.returnnotfound.stain.data.repository.source.BannerLocalSource
import com.returnnotfound.stain.data.repository.source.BannerRemoteSource
import com.returnnotfound.stain.domain.model.Banner
import com.returnnotfound.stain.domain.repository.BannerRepository
import javax.inject.Inject

class BannerRepositoryImpl @Inject constructor(
  private val bannerLocalSource: BannerLocalSource,
  private val bannerRemoteSource: BannerRemoteSource
) : BannerRepository {

  override suspend fun getBannerList(): List<Banner> {
    return bannerLocalSource.getBannerList()
  }
}
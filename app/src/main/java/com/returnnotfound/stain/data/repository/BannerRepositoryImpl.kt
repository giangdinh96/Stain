package com.returnnotfound.stain.data.repository

import com.returnnotfound.stain.data.repository.source.BannerLocalSource
import com.returnnotfound.stain.data.repository.source.BannerRemoteSource
import com.returnnotfound.stain.domain.model.Banner
import com.returnnotfound.stain.domain.repository.BannerRepository
import io.reactivex.Single
import javax.inject.Inject

class BannerRepositoryImpl @Inject constructor(
  private val bannerLocalSource: BannerLocalSource,
  private val bannerRemoteSource: BannerRemoteSource
) : BannerRepository {
  override fun getBannerList(): Single<List<Banner>> {
    return bannerLocalSource.getBannerList()
  }

}
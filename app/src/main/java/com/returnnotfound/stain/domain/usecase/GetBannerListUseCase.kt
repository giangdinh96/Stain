package com.returnnotfound.stain.domain.usecase

import com.returnnotfound.stain.domain.model.Banner
import com.returnnotfound.stain.domain.repository.BannerRepository
import io.reactivex.Single
import javax.inject.Inject

class GetBannerListUseCase @Inject constructor(private val bannerRepository: BannerRepository) {

  operator fun invoke(): Single<List<Banner>> {
    return bannerRepository.getBannerList()
  }
}
package com.returnnotfound.stain.domain.usecase

import com.returnnotfound.stain.domain.repository.BannerRepository
import javax.inject.Inject

class GetBannerListUseCase @Inject constructor(private val bannerRepository: BannerRepository) {

  suspend operator fun invoke() {
//    bannerRepository.getBannerList()
  }
}
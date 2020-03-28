package com.returnnotfound.stain.domain.repository

import com.returnnotfound.stain.domain.model.Banner

interface BannerRepository {
  suspend fun getBannerList(): List<Banner>
}
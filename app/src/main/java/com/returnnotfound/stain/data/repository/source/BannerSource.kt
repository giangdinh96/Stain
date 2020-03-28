package com.returnnotfound.stain.data.repository.source

import com.returnnotfound.stain.domain.model.Banner

interface BannerLocalSource {
  suspend fun getBannerList(): List<Banner>
}

interface BannerRemoteSource {
  suspend fun getBannerList(): List<Banner>
}
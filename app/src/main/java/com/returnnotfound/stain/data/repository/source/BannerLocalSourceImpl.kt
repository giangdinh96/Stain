package com.returnnotfound.stain.data.repository.source

import com.returnnotfound.stain.domain.model.Banner
import javax.inject.Inject

class BannerLocalSourceImpl @Inject constructor() :
  BannerLocalSource {
  override suspend fun getBannerList(): List<Banner> {
    TODO("Not yet implemented")
  }

}
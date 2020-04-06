package com.returnnotfound.stain.domain.repository

import com.returnnotfound.stain.domain.model.Banner
import io.reactivex.Single

interface BannerRepository {
  fun getBannerList(): Single<List<Banner>>
}
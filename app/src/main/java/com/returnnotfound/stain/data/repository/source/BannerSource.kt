package com.returnnotfound.stain.data.repository.source

import com.returnnotfound.stain.domain.model.Banner
import io.reactivex.Single

interface BannerLocalSource {
  fun getBannerList(): Single<List<Banner>>
}

interface BannerRemoteSource {
}
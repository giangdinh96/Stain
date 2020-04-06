package com.returnnotfound.stain.data.mapper

import com.returnnotfound.stain.data.model.BannerRealmEntity
import com.returnnotfound.stain.domain.model.Banner

fun BannerRealmEntity.toDomain(): Banner {
  return Banner(id, name, image, story?.id)
}
package com.returnnotfound.stain.presentation.mapper

import com.returnnotfound.stain.domain.model.Banner
import com.returnnotfound.stain.presentation.model.BannerModel

fun Banner.toPresentation(): BannerModel {
  return BannerModel(id, name, image, storyId)
}
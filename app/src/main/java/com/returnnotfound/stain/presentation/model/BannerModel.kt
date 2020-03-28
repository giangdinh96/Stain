package com.returnnotfound.stain.presentation.model

data class BannerModel(
  var id: Int,
  var title: String,
  var image: String,
  var type: String,
  var animeId: Int,
  var mangaId: Int
)
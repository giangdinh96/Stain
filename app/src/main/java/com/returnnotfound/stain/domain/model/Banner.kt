package com.returnnotfound.stain.domain.model

data class Banner(
  var id: Int,
  var title: String,
  var image: String,
  var type: String,
  var animeId: Int,
  var mangaId: Int
)
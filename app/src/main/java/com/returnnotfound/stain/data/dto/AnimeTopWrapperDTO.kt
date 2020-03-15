package com.returnnotfound.stain.data.dto

import com.google.gson.annotations.SerializedName

class AnimeTopWrapperDTO {
  @SerializedName("error")
  var error: String? = null

  @SerializedName("top")
  var topList: List<AnimeTopDTO>? = null
}
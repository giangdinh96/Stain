package com.returnnotfound.stain.data.dto

import com.google.gson.annotations.SerializedName

class AnimeTopDTO {
  @SerializedName("mal_id")
  var malId = 0

  @SerializedName("rank")
  var rank = 0

  @SerializedName("title")
  var title: String? = null

  @SerializedName("url")
  var url: String? = null

  @SerializedName("image_url")
  var imageUrl: String? = null

  @SerializedName("type")
  var type: String? = null

  @SerializedName("members")
  var members = 0

  @SerializedName("score")
  var score = 0

  @SerializedName("start_date")
  var startDate: String? = null

}
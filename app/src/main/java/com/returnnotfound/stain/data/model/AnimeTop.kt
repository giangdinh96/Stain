package com.returnnotfound.stain.data.model

class AnimeTop {
  var malId = 0
  var rank = 0
  var title: String? = null
  var url: String? = null
  var imageUrl: String? = null
  var type: String? = null
  var members = 0
  var score = 0
  var startDate: String? = null

  val rankColor: String
    get() = when (rank) {
      1 -> "#218517"
      2 -> "#E91E63"
      3 -> "#772363"
      else -> "#A5743F"
    }
}
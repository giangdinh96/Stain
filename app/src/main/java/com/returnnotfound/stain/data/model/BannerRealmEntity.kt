package com.returnnotfound.stain.data.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class BannerRealmEntity() : RealmObject() {
  @PrimaryKey
  var id: Int = 0
  var title: String? = null
  var image: String? = null
  var type: String? = null
  var animeId: Int = 0
  var mangaId: Int = 0
}
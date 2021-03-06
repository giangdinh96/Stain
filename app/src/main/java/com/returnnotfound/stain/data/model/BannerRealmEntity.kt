package com.returnnotfound.stain.data.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*


open class BannerRealmEntity() : RealmObject() {
  @PrimaryKey
  var id: String = UUID.randomUUID().toString()
  var name: String? = null
  var image: String? = null
  var story: StoryRealmEntity? = null
  var createdAt: Date = Date()
  var updatedAt: Date = Date()

  fun updateTime() {
    updatedAt = Date()
  }
}
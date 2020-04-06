package com.returnnotfound.stain.data.model

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class ChapterRealmEntity : RealmObject() {
  @PrimaryKey
  var id: String = UUID.randomUUID().toString()
  var name: String? = null
  var images: RealmList<String> = RealmList<String>()
  var createdAt: Date = Date()
  var updatedAt: Date = Date()

  fun updateTime() {
    updatedAt = Date()
  }
}
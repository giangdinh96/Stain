package com.returnnotfound.stain.data.repository.source

import com.returnnotfound.stain.data.mapper.toDomain
import com.returnnotfound.stain.data.model.BannerRealmEntity
import com.returnnotfound.stain.domain.model.Banner
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import io.realm.Realm
import io.realm.kotlin.where
import javax.inject.Inject
import javax.inject.Provider

class BannerLocalSourceImpl @Inject constructor(val realm: Provider<Realm>) : BannerLocalSource {
  override fun getBannerList(): Single<List<Banner>> {
    return Observable.fromCallable {
      realm.get().where<BannerRealmEntity>().limit(10).findAll()
    }.flatMap { Observable.fromIterable(it) }
      .map { it.toDomain() }
      .toList()
      .subscribeOn(Schedulers.io())
  }

}
package com.returnnotfound.stain.di.module

import com.returnnotfound.stain.data.model.BannerRealmEntity
import dagger.Module
import dagger.Provides
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmMigration
import javax.inject.Singleton

@Module
object RealmConfigModule {
  @JvmStatic
  @Provides
  fun provideRealm(realmConfiguration: RealmConfiguration): Realm =
    Realm.getInstance(realmConfiguration)

  @JvmStatic
  @Singleton
  @Provides
  fun provideRealmConfig(
    realmTransaction: Realm.Transaction,
    migration: RealmMigration
  ): RealmConfiguration =
    RealmConfiguration
      .Builder()
      .name("MyRealm.realm")
      .schemaVersion(1)
      .initialData(realmTransaction)
      .migration(migration)
      .build()

  @JvmStatic
  @Singleton
  @Provides
  fun provideInitData(): Realm.Transaction = Realm.Transaction {
    val images = listOf(
      "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__340.jpg",
      "https://cdn.pixabay.com/photo/2015/02/24/15/41/dog-647528__340.jpg",
      "https://cdn.shopify.com/s/files/1/1327/6929/files/Greece-Zakynthos-Ionian-Islands-960x600_1024x1024.jpg?v=1521125276",
      "https://i.etsystatic.com/13906434/r/il/bb5d11/1415398468/il_570xN.1415398468_9o91.jpg",
      "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__340.jpg",
      "https://cdn.pixabay.com/photo/2015/02/24/15/41/dog-647528__340.jpg",
      "https://cdn.shopify.com/s/files/1/1327/6929/files/Greece-Zakynthos-Ionian-Islands-960x600_1024x1024.jpg?v=1521125276",
      "https://i.etsystatic.com/13906434/r/il/bb5d11/1415398468/il_570xN.1415398468_9o91.jpg"
    )

    for (i in images) {
      val item = BannerRealmEntity()
      item.image = i
      item.name = "Picture $i"
      it.copyToRealmOrUpdate(item)
    }
  }

  @JvmStatic
  @Singleton
  @Provides
  fun provideMigration(): RealmMigration = RealmMigration { realm, old, new ->
    var oldVersion = old
    if (oldVersion == 1L) {

      oldVersion++
    }

    if (oldVersion == 2L) {

      oldVersion++
    }
  }
}
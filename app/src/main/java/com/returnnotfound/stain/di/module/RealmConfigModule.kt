package com.returnnotfound.stain.di.module

import dagger.Module
import dagger.Provides
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Singleton

@Module
object RealmConfigModule {
  @JvmStatic
  @Singleton
  @Provides
  fun provideRealmConfig(): RealmConfiguration =
    RealmConfiguration
      .Builder()
      .name("MyRealm.realm")
      .schemaVersion(1)
      .initialData {
        // Init data
      }
      .migration { realm, old, new ->
        var oldVersion = old
        if (oldVersion == 1L) {

          oldVersion++
        }

        if (oldVersion == 2L) {

          oldVersion++
        }
      }
      .build()

  @JvmStatic
  @Provides
  fun provideRealm(realmConfiguration: RealmConfiguration): Realm =
    Realm.getInstance(realmConfiguration)
}
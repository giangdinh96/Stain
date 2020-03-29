package com.returnnotfound.stain.di.module

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
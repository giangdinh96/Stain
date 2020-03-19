package com.returnnotfound.stain.di.module

import com.returnnotfound.stain.data.remote.AnimeService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
object ApiServiceModule {
  @JvmStatic
  @Provides
  @Singleton
  fun provideAnimeService(retrofit: Retrofit): AnimeService {
    return retrofit.create(AnimeService::class.java)
  }
}
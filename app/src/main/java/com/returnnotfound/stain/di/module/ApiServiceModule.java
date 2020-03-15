package com.returnnotfound.stain.di.module;

import com.returnnotfound.stain.data.remote.AnimeService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public abstract class ApiServiceModule {
  @Provides
  @Singleton
  static AnimeService provideAnimeService(Retrofit retrofit) {
    return retrofit.create(AnimeService.class);
  }
}

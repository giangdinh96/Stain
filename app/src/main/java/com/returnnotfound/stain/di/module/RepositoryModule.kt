package com.returnnotfound.stain.di.module

import com.returnnotfound.stain.data.repository.AnimeRepository
import com.returnnotfound.stain.data.repository.AnimeRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
  @Binds
  abstract fun bindAnimeRepository(animeRepository: AnimeRepositoryImpl): AnimeRepository
}
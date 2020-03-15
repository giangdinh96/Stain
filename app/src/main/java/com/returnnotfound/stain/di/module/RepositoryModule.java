package com.returnnotfound.stain.di.module;

import com.returnnotfound.stain.data.repository.AnimeRepository;
import com.returnnotfound.stain.data.repository.AnimeRepositoryImpl;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class RepositoryModule {

  @Binds
  abstract AnimeRepository bindAnimeRepository(AnimeRepositoryImpl animeRepository);
}

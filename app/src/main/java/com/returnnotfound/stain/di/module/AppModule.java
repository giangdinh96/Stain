package com.returnnotfound.stain.di.module;

import android.content.Context;

import com.returnnotfound.stain.App;
import com.returnnotfound.stain.di.AppContext;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class AppModule {

  @Binds
  @AppContext
  @Singleton
  abstract Context bindAppContext(App app);
}

package com.returnnotfound.stain.di.module

import android.content.Context
import com.returnnotfound.stain.App
import com.returnnotfound.stain.di.AppContext
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class AppModule {
  @Binds
  @AppContext
  @Singleton
  abstract fun bindAppContext(app: App): Context
}
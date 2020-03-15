package com.returnnotfound.stain

import android.content.Context
import androidx.multidex.MultiDex
import com.returnnotfound.stain.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.github.inflationx.viewpump.ViewPump
import javax.inject.Inject

class App : DaggerApplication() {
  @Inject
  lateinit var viewPump: ViewPump

  override fun attachBaseContext(base: Context) {
    super.attachBaseContext(base)
    MultiDex.install(this)
  }

  override fun onCreate() {
    super.onCreate()
    instance = this
    // Init font
    ViewPump.init(viewPump)
  }

  override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
    return DaggerAppComponent.factory().create(this)
  }

  companion object {
    var instance: App? = null
      private set
  }
}
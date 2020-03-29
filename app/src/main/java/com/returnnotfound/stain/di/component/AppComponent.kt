package com.returnnotfound.stain.di.component

import com.returnnotfound.stain.App
import com.returnnotfound.stain.di.module.*
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
  modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    FontConfigModule::class,
    NetworkConfigModule::class,
    RealmConfigModule::class,
    ActivityBuilder::class,
    FragmentBuilder::class,
    ViewModelModule::class,
    DataSourceModule::class,
    RepositoryModule::class
  ]
)
interface AppComponent : AndroidInjector<App> {
  @Component.Factory
  interface Factory : AndroidInjector.Factory<App>
}
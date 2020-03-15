package com.returnnotfound.stain.di.component;

import com.returnnotfound.stain.App;
import com.returnnotfound.stain.di.module.ActivityBuilder;
import com.returnnotfound.stain.di.module.ApiServiceModule;
import com.returnnotfound.stain.di.module.AppModule;
import com.returnnotfound.stain.di.module.FontModule;
import com.returnnotfound.stain.di.module.NetworkConfigModule;
import com.returnnotfound.stain.di.module.RepositoryModule;
import com.returnnotfound.stain.di.module.ViewModelModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(
    modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        FontModule.class,
        NetworkConfigModule.class,
        ApiServiceModule.class,
        RepositoryModule.class,
        ActivityBuilder.class,
        ViewModelModule.class
    })
public interface AppComponent extends AndroidInjector<App> {
  @Component.Factory
  interface Factory extends AndroidInjector.Factory<App> {

  }
}

package com.returnnotfound.stain.di.module;

import com.returnnotfound.stain.di.ActivityScope;
import com.returnnotfound.stain.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

  @ContributesAndroidInjector(modules = FragmentBuilder.class)
  @ActivityScope
  abstract MainActivity contributeMainActivity();
}

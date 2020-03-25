package com.returnnotfound.stain.di.module

import com.returnnotfound.stain.di.ActivityScope
import com.returnnotfound.stain.presentation.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
  @ContributesAndroidInjector(modules = [FragmentBuilder::class])
  @ActivityScope
  abstract fun contributeMainActivity(): MainActivity
}
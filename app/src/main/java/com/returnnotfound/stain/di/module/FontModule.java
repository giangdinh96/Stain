package com.returnnotfound.stain.di.module;

import com.returnnotfound.stain.R;
import com.returnnotfound.stain.di.FontPathDefault;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;

import static com.returnnotfound.stain.CoreDefaultKt.FONT_DEFAULT_PATH;

@Module
public abstract class FontModule {

  @FontPathDefault
  @Singleton
  @Provides
  static String provideFontPathDefault() {
    return FONT_DEFAULT_PATH;
  }

  @Singleton
  @Provides
  static CalligraphyInterceptor provideCalligraphyInterceptor(@FontPathDefault String fontPathDefault) {
    return new CalligraphyInterceptor(
        new CalligraphyConfig.Builder()
            .setDefaultFontPath(fontPathDefault)
            .setFontAttrId(R.attr.fontPath)
            .build()
    );
  }

  @Singleton
  @Provides
  static ViewPump provideViewPump(CalligraphyInterceptor calligraphyInterceptor) {
    return ViewPump.builder().addInterceptor(calligraphyInterceptor).build();
  }

}

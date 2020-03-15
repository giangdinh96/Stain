package com.returnnotfound.stain.di.module;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.returnnotfound.stain.BuildConfig;
import com.returnnotfound.stain.data.remote.AuthenticationInterceptor;
import com.returnnotfound.stain.di.AppContext;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.returnnotfound.stain.LogTagKt.LOG_TAG_NETWORK;

@Module
public abstract class NetworkConfigModule {

  @Provides
  @Singleton
  static Retrofit provideRetrofit(OkHttpClient okHttpClient, GsonConverterFactory gsonConverterFactory, RxJava2CallAdapterFactory rxJava2CallAdapterFactory) {
    return new Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(gsonConverterFactory)
        .addCallAdapterFactory(rxJava2CallAdapterFactory)
        .build();
  }

  @Provides
  static GsonConverterFactory provideGsonConverterFactory(Gson gson) {
    return GsonConverterFactory.create(gson);
  }

  @Provides
  static Gson provideGson() {
    return new GsonBuilder()
        .setLenient()
        .setPrettyPrinting()
        .create();
  }

  @Provides
  static RxJava2CallAdapterFactory provideRxJava2CallAdapterFactory() {
    return RxJava2CallAdapterFactory.create();
  }

  @Provides
  @Singleton
  static OkHttpClient provideOkHttpClient(AuthenticationInterceptor authenticationInterceptor, HttpLoggingInterceptor httpLoggingInterceptor, Cache cache) {
    return new OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .writeTimeout(15, TimeUnit.SECONDS)
//        .cache(cache)
        .addInterceptor(authenticationInterceptor)
        .addInterceptor(httpLoggingInterceptor)
        .build();
  }

  @Provides
  @Singleton
  static HttpLoggingInterceptor provideHttpLoggingInterceptor() {
    HttpLoggingInterceptor result = new HttpLoggingInterceptor(s -> Log.e(LOG_TAG_NETWORK, s));
    result.setLevel(HttpLoggingInterceptor.Level.BODY);
    return result;
  }

  @Provides
  @Singleton
  static Cache provideCache(@AppContext Context context) {
    int sizeMb = 20;
    return new Cache(context.getCacheDir(), sizeMb * 1024 * 1024);
  }
}

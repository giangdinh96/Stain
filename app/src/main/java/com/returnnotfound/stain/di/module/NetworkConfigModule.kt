package com.returnnotfound.stain.di.module

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.returnnotfound.stain.BuildConfig
import com.returnnotfound.stain.LOG_TAG_NETWORK
import com.returnnotfound.stain.data.remote.AuthenticationInterceptor
import com.returnnotfound.stain.di.AppContext
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
object NetworkConfigModule {

  @JvmStatic
  @Provides
  @Singleton
  fun provideRetrofit(
    okHttpClient: OkHttpClient,
    gsonConverterFactory: GsonConverterFactory,
    rxJava2CallAdapterFactory: RxJava2CallAdapterFactory
  ): Retrofit {
    return Retrofit.Builder()
      .baseUrl(BuildConfig.BASE_URL)
      .client(okHttpClient)
      .addConverterFactory(gsonConverterFactory)
      .addCallAdapterFactory(rxJava2CallAdapterFactory)
      .build()
  }

  @JvmStatic
  @Provides
  fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory {
    return GsonConverterFactory.create(gson)
  }

  @JvmStatic
  @Provides
  fun provideGson(): Gson {
    return GsonBuilder()
      .setLenient()
      .setPrettyPrinting()
      .create()
  }

  @JvmStatic
  @Provides
  fun provideRxJava2CallAdapterFactory(): RxJava2CallAdapterFactory {
    return RxJava2CallAdapterFactory.create()
  }

  @JvmStatic
  @Provides
  @Singleton
  fun provideOkHttpClient(
    authenticationInterceptor: AuthenticationInterceptor,
    httpLoggingInterceptor: HttpLoggingInterceptor,
    cache: Cache
  ): OkHttpClient {
    return OkHttpClient.Builder()
      .connectTimeout(10, TimeUnit.SECONDS)
      .readTimeout(15, TimeUnit.SECONDS)
      .writeTimeout(15, TimeUnit.SECONDS)
//      .cache(cache)
      .addInterceptor(authenticationInterceptor)
      .addInterceptor(httpLoggingInterceptor)
      .build()
  }

  @JvmStatic
  @Provides
  @Singleton
  fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
    val result = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
      override fun log(message: String) {
        Log.e(LOG_TAG_NETWORK, message)
      }

    })
    result.setLevel(HttpLoggingInterceptor.Level.BODY)
    return result
  }

  @JvmStatic
  @Provides
  @Singleton
  fun provideCache(@AppContext context: Context): Cache {
    val sizeMb = 20
    return Cache(context.cacheDir, (sizeMb * 1024 * 1024).toLong())
  }
}
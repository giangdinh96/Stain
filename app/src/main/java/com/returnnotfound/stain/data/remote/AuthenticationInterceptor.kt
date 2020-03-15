package com.returnnotfound.stain.data.remote

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthenticationInterceptor @Inject constructor() : Interceptor {
  @Throws(IOException::class)
  override fun intercept(chain: Interceptor.Chain): Response {
    val originRequest = chain.request()
    val newRequest = originRequest.newBuilder()
      .addHeader("x-rapidapi-host", "jikan1.p.rapidapi.com")
      .addHeader("x-rapidapi-key", "8bf08a015fmshe4eb867c5d11bd1p120233jsn319a0d71e18a")
      .build()
    return chain.proceed(newRequest)
  }
}
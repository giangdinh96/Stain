package com.returnnotfound.stain.data.remote;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@Singleton
public class AuthenticationInterceptor implements Interceptor {

  @Inject
  public AuthenticationInterceptor() {

  }

  @NotNull
  @Override
  public Response intercept(@NotNull Chain chain) throws IOException {
    Request originRequest = chain.request();
    Request newRequest = originRequest.newBuilder()
        .addHeader("x-rapidapi-host", "jikan1.p.rapidapi.com")
        .addHeader("x-rapidapi-key", "8bf08a015fmshe4eb867c5d11bd1p120233jsn319a0d71e18a")
        .build();
    return chain.proceed(newRequest);
  }
}

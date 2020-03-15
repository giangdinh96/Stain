package com.returnnotfound.stain.data.remote

import com.returnnotfound.stain.data.dto.AnimeTopWrapperDTO
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeService {
  @GET("top/anime/{page}/{subtype}")
  fun getTop(
    @Path("page") page: Int,
    @Path("subtype") subType: String?
  ): Single<AnimeTopWrapperDTO?>?
}
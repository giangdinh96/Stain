package com.returnnotfound.stain.data.remote;

import com.returnnotfound.stain.data.dto.AnimeTopWraperDTO;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AnimeService {
  @GET("top/anime/{page}/{subtype}")
  Single<AnimeTopWraperDTO> getTop(@Path("page") int page, @Path("subtype") String subType);
}

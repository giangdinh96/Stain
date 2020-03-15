package com.returnnotfound.stain.data.repository;

import com.returnnotfound.stain.data.model.AnimeTop;

import java.util.List;

import io.reactivex.Single;

public interface AnimeRepository {
  Single<List<AnimeTop>> getAnimeTop(int page, String subType);
}

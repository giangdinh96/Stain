package com.returnnotfound.stain.data.repository;

import com.returnnotfound.stain.data.dto.AnimeTopWraperDTO;
import com.returnnotfound.stain.data.mapper.AnimeTopWraperMapper;
import com.returnnotfound.stain.data.model.AnimeTop;
import com.returnnotfound.stain.data.remote.AnimeService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class AnimeRepositoryImpl implements AnimeRepository {
  private AnimeService mAnimeService;

  @Inject
  public AnimeRepositoryImpl(AnimeService animeService) {
    this.mAnimeService = animeService;
  }

  @Override
  public Single<List<AnimeTop>> getAnimeTop(int page, String subType) {
    return mAnimeService.getTop(page, subType)
        .map((AnimeTopWraperDTO animeTopWraperDTO) -> AnimeTopWraperMapper.INSTANCE.toModel(animeTopWraperDTO).getTopList());
  }
}


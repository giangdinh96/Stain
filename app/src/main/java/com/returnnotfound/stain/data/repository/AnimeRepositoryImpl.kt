package com.returnnotfound.stain.data.repository

import com.returnnotfound.stain.data.dto.AnimeTopWrapperDTO
import com.returnnotfound.stain.data.mapper.AnimeTopWrapperMapper
import com.returnnotfound.stain.data.model.AnimeTop
import com.returnnotfound.stain.data.remote.AnimeService
import io.reactivex.Single
import javax.inject.Inject

class AnimeRepositoryImpl @Inject constructor(private val mAnimeService: AnimeService) :
  AnimeRepository {

  override fun getAnimeTop(
    page: Int,
    subType: String?
  ): Single<List<AnimeTop?>?>? {
    return mAnimeService.getTop(page, subType)?.map { animeTopWrapperDTO: AnimeTopWrapperDTO? ->
      AnimeTopWrapperMapper.INSTANCE.toModel(animeTopWrapperDTO)?.topList
    }
  }

}
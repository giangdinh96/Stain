package com.returnnotfound.stain.data.repository

import com.returnnotfound.stain.data.model.AnimeTop
import io.reactivex.Single

interface AnimeRepository {
  fun getAnimeTop(
    page: Int,
    subType: String?
  ): Single<List<AnimeTop?>?>?
}
package com.returnnotfound.stain.data.mapper

import com.returnnotfound.stain.data.dto.AnimeTopDTO
import com.returnnotfound.stain.data.model.AnimeTop
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper
interface AnimeTopMapper {
  fun toModel(dto: AnimeTopDTO?): AnimeTop?

  companion object {
    val INSTANCE = Mappers.getMapper(AnimeTopMapper::class.java)
  }
}
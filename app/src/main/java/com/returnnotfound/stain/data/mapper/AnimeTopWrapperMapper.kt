package com.returnnotfound.stain.data.mapper

import com.returnnotfound.stain.data.dto.AnimeTopWrapperDTO
import com.returnnotfound.stain.data.model.AnimeTopWrapper
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper
interface AnimeTopWrapperMapper {
  fun toModel(dto: AnimeTopWrapperDTO?): AnimeTopWrapper?

  companion object {
    val INSTANCE: AnimeTopWrapperMapper = Mappers.getMapper(AnimeTopWrapperMapper::class.java)
  }
}
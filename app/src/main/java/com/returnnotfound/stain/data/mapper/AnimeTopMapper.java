package com.returnnotfound.stain.data.mapper;

import com.returnnotfound.stain.data.dto.AnimeTopDTO;
import com.returnnotfound.stain.data.model.AnimeTop;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnimeTopMapper {
  AnimeTopMapper INSTANCE = Mappers.getMapper(AnimeTopMapper.class);

  AnimeTop toModel(AnimeTopDTO dto);
}

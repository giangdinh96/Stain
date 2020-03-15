package com.returnnotfound.stain.data.mapper;

import com.returnnotfound.stain.data.dto.AnimeTopWraperDTO;
import com.returnnotfound.stain.data.model.AnimeTopWraper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnimeTopWraperMapper {
  AnimeTopWraperMapper INSTANCE = Mappers.getMapper(AnimeTopWraperMapper.class);

  AnimeTopWraper toModel(AnimeTopWraperDTO dto);
}

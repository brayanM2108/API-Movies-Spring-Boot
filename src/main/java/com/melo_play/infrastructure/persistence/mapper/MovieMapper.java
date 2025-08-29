package com.melo_play.infrastructure.persistence.mapper;
import com.melo_play.domain.dto.MovieDto;
import com.melo_play.infrastructure.persistence.MovieEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {GenreMapper.class})
public interface MovieMapper {


    @Mapping(target = "genre", qualifiedByName = "stringToGenre")
    MovieDto toDto(MovieEntity movieEntity);

    @Mapping(target = "status", ignore = true)
    @Mapping(target = "id", ignore = true)
    MovieEntity toEntity(MovieDto movieDto);



    List<MovieDto> toDtoList(List<MovieEntity> movieEntities);

    List<MovieEntity> toEntityList(List<MovieDto> movieDtos);
}

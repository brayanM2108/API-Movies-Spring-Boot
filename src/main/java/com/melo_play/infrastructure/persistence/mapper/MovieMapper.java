package com.melo_play.infrastructure.persistence.mapper;
import com.melo_play.domain.dto.MovieDto;
import com.melo_play.domain.dto.UpdateMovieDto;
import com.melo_play.infrastructure.persistence.MovieEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {GenreMapper.class, StatusMapper.class})
public interface MovieMapper {


    @Mapping(target = "genre", qualifiedByName = "stringToGenre")
    MovieDto toDto(MovieEntity movieEntity);

    @InheritInverseConfiguration
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "genre", qualifiedByName = "genreToString")
    MovieEntity toEntity(MovieDto movieDto);

    List<MovieDto> toDtoList(List<MovieEntity> movieEntities);


    @Mapping(target = "genre", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "duration", ignore = true)
    @Mapping(target = "status", source = "status", qualifiedByName = "statusToString")
    void updateEntity(UpdateMovieDto movieDto, @MappingTarget MovieEntity movieEntity);

    List<MovieEntity> toEntityList(List<MovieDto> movieDtos);
}

package com.melo_play.infrastructure.persistence;

import com.melo_play.domain.dto.MovieDto;
import com.melo_play.domain.repository.IMovieRepository;
import com.melo_play.infrastructure.crud.CrudMovieEntity;
import com.melo_play.infrastructure.persistence.mapper.MovieMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class MovieRepositoryImpl implements IMovieRepository {

    private final CrudMovieEntity crudMovieEntity;
    private final MovieMapper movieMapper ;

    public MovieRepositoryImpl(CrudMovieEntity crudMovieEntity, MovieMapper movieMapper) {
        this.crudMovieEntity = crudMovieEntity;
        this.movieMapper = movieMapper;
    }

    @Override
    public List<MovieDto> findAll() {
        return movieMapper.toDtoList(crudMovieEntity.findAll());
    }
}

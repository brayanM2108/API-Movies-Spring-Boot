package com.melo_play.infrastructure.persistence;

import com.melo_play.domain.dto.MovieDto;
import com.melo_play.domain.dto.UpdateMovieDto;
import com.melo_play.domain.exception.MovieAlreadyExistException;
import com.melo_play.domain.exception.MovieDoesNotExist;
import com.melo_play.domain.repository.IMovieRepository;
import com.melo_play.infrastructure.crud.CrudMovieEntity;
import com.melo_play.infrastructure.persistence.mapper.MovieMapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<MovieDto> findById(Long id) {
        return crudMovieEntity.findById(id).map(movieMapper::toDto);
    }

    @Override
    public MovieDto save(MovieDto movieDto) {

        if (crudMovieEntity.findByTitle(movieDto.title()) != null) {
            throw new MovieAlreadyExistException(movieDto.title());
        };


        MovieEntity movieEntity = movieMapper.toEntity(movieDto);
        movieEntity.setStatus("A");
        return movieMapper.toDto(crudMovieEntity.save(movieEntity));
    }

    @Override
    public MovieDto update(Long id, UpdateMovieDto updateMovieDto) {
        MovieEntity movieEntity = crudMovieEntity.findById(id).orElse(null);
        if (movieEntity == null) return null;

        movieMapper.updateEntity(updateMovieDto, movieEntity);
        return movieMapper.toDto(crudMovieEntity.save(movieEntity));
    }

    @Override
    public void deleteById(Long id) {

        if (crudMovieEntity.findById(id).isEmpty()) {
            throw new MovieDoesNotExist(id);
        }

        crudMovieEntity.deleteById(id);
    }
}

package com.melo_play.domain.repository;

import com.melo_play.domain.dto.MovieDto;
import com.melo_play.domain.dto.UpdateMovieDto;

import java.util.List;
import java.util.Optional;

public interface IMovieRepository {

    List<MovieDto> findAll();

    Optional <MovieDto> findById(Long id);

    MovieDto save(MovieDto movieDto);

    MovieDto update(Long id, UpdateMovieDto updateMovieDto);

    void deleteById(Long id);
}

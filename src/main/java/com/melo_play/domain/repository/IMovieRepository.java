package com.melo_play.domain.repository;

import com.melo_play.domain.dto.MovieDto;

import java.util.List;

public interface IMovieRepository {

    List<MovieDto> findAll();
}

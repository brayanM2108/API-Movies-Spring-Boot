package com.melo_play.domain.services;

import com.melo_play.domain.dto.MovieDto;
import com.melo_play.domain.repository.IMovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final IMovieRepository movieRepository;


    public MovieService(IMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDto> getAll() {
        return movieRepository.findAll();
    }
}

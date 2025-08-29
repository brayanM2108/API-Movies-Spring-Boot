package com.melo_play.web.controller;


import com.melo_play.domain.dto.MovieDto;
import com.melo_play.domain.services.MovieService;
import com.melo_play.infrastructure.crud.CrudMovieEntity;
import com.melo_play.infrastructure.persistence.MovieEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public List<MovieDto> getAll() {
        return movieService.getAll();
    }
}

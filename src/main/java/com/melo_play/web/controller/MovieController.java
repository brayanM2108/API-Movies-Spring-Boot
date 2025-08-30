package com.melo_play.web.controller;


import com.melo_play.domain.dto.MovieDto;
import com.melo_play.domain.dto.SuggestRequestDto;
import com.melo_play.domain.dto.UpdateMovieDto;
import com.melo_play.domain.services.AIPlayService;
import com.melo_play.domain.services.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    private final MovieService movieService;
    private final AIPlayService aiService;

    public MovieController(MovieService movieService, AIPlayService aiService) {
        this.movieService = movieService;
        this.aiService = aiService;
    }

    @GetMapping()
    public ResponseEntity<List<MovieDto>> getAll() {
        return new ResponseEntity<>(movieService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity <MovieDto> getById(@PathVariable long id) {
        return ResponseEntity.of(movieService.getById(id));
    }

    @PostMapping("/suggestion")
    public ResponseEntity<String> generateMoviesSuggestions(@RequestBody SuggestRequestDto suggestRequestDto) {
        return ResponseEntity.ok(aiService.generateMoviesSuggestions(suggestRequestDto.userPreferences()));
    }

    @PostMapping()
    public ResponseEntity<MovieDto> save (@RequestBody MovieDto movieDto){
        return new ResponseEntity<>(movieService.save(movieDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> update (@PathVariable long id, @RequestBody UpdateMovieDto movieDto){
        return new ResponseEntity<>(movieService.update(id, movieDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        movieService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

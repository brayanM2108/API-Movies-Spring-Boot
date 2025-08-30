package com.melo_play.web.controller;

import com.melo_play.domain.dto.MovieDto;
import com.melo_play.domain.dto.SuggestRequestDto;
import com.melo_play.domain.dto.UpdateMovieDto;
import com.melo_play.domain.services.AIPlayService;
import com.melo_play.domain.services.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Movies", description = "Movie management operations")
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    private final MovieService movieService;
    private final AIPlayService aiService;

    public MovieController(MovieService movieService, AIPlayService aiService) {
        this.movieService = movieService;
        this.aiService = aiService;
    }


    @Operation(
            summary = "Get all movies",
            description = "Retrieves a list of all movies",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Movies retrieved successfully")
            }
    )
    @GetMapping()
    public ResponseEntity<List<MovieDto>> getAll() {
        return new ResponseEntity<>(movieService.getAll(), HttpStatus.OK);
    }

    @Operation(
            summary = "Get movie by ID",
            description = "Retrieves a specific movie by its ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Movie found"),
                    @ApiResponse(responseCode = "404", description = "Movie not found", content = @Content)
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity <MovieDto> getById(@Parameter (description = "ID from de movie retrieved ", example = "8") @PathVariable long id) {
        return ResponseEntity.of(movieService.getById(id));
    }


    @Operation(
            summary = "Get suggestions of movies based on user preferences",
            description = "Generate movies suggestions bassed on user preferencesusing AI",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Suggestions generated successfully")
            }
    )
    @PostMapping("/suggestion")
    public ResponseEntity<String> generateMoviesSuggestions(  @RequestBody SuggestRequestDto suggestRequestDto) {
        return ResponseEntity.ok(aiService.generateMoviesSuggestions(suggestRequestDto.userPreferences()));
    }

    @Operation(
            summary = "Create a new movie",
            description = "Creates and saves a new movie",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Movie created successfully"),
                    @ApiResponse(responseCode = "400", description = "Invalid movie data")
            }
    )
    @PostMapping()
    public ResponseEntity<MovieDto> save (@RequestBody @Valid MovieDto movieDto){
        return new ResponseEntity<>(movieService.save(movieDto), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Update a movie",
            description = "Updates an existing movie by its ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Movie updated successfully"),
                    @ApiResponse(responseCode = "404", description = "Movie not found", content = @Content),
                    @ApiResponse(responseCode = "400", description = "Invalid movie data")
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> update (@Parameter(description = "Movie ID", required = true)@PathVariable long id,
                                            @RequestBody @Valid UpdateMovieDto movieDto){
        return new ResponseEntity<>(movieService.update(id, movieDto), HttpStatus.OK);
    }

    @Operation(
            summary = "Delete a movie",
            description = "Deletes a movie by its ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Movie deleted successfully"),
                    @ApiResponse(responseCode = "404", description = "Movie not found", content = @Content)
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@Parameter(description = "Movie ID", required = true)  @PathVariable Long id) {
        movieService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

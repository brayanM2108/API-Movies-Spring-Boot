package com.melo_play.domain.services;

import com.melo_play.domain.dto.MovieDto;
import com.melo_play.domain.dto.UpdateMovieDto;
import com.melo_play.domain.repository.IMovieRepository;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final IMovieRepository movieRepository;


    public MovieService(IMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Tool("Busca todas las películas que existan dentro de la plataforma")
    public List<MovieDto> getAll() {
        return movieRepository.findAll();
    }

    public Optional<MovieDto> getById(Long id) {
        return movieRepository.findById(id);
    }

    public MovieDto save(MovieDto movieDto) {
        return movieRepository.save(movieDto);
    }

    public MovieDto update (long id, UpdateMovieDto updateMovieDto){
        return movieRepository.update(id, updateMovieDto);
    }

    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }
}



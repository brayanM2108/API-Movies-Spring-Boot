package com.melo_play.domain.dto;

import com.melo_play.domain.Genre;

import java.time.LocalDate;

public record MovieDto (
    String title,
    Integer duration,
    Genre genre,
    LocalDate releaseDate,
    Double rating
){
}

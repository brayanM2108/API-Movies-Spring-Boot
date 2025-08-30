package com.melo_play.domain.dto;

import com.melo_play.domain.Status;

import java.time.LocalDate;

public record UpdateMovieDto (
        String title,
        LocalDate releaseDate,
        Double rating,
        Status status

) {
}

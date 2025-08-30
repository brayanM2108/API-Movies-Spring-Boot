package com.melo_play.domain.dto;

import com.melo_play.domain.Status;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import java.time.LocalDate;

public record UpdateMovieDto (

        @NotBlank(message = "Title cannot be blank")
        String title,

        @PastOrPresent(message = "Release date must be in the past or present")
        LocalDate releaseDate,

        @Min(value = 0, message = "Rating must be greater than 0")
        @Max(value = 5, message = "Rating must be less than 5")
        Double rating,


        Status status

) {
}

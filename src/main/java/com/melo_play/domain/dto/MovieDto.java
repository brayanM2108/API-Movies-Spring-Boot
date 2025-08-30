package com.melo_play.domain.dto;

import com.melo_play.domain.Genre;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record MovieDto (

    Long id,

    @NotBlank(message = "Title cannot be blank")
    String title,

    @Min(value = 0, message = "Duration must be greater than 0")
    Integer duration,

    Genre genre,

    @PastOrPresent(message = "Release date must be in the past or present")
    LocalDate releaseDate,

    @Min(value = 0, message = "Rating must be greater than 0")
    @Max(value = 5, message = "Rating must be less than 5")
    Double rating
){
}

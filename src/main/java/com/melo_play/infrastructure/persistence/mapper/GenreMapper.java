package com.melo_play.infrastructure.persistence.mapper;

import com.melo_play.domain.Genre;
import org.mapstruct.Named;

public class GenreMapper {

    @Named( "genreToString")
    public static String genreToString(Genre genre) {

        if (genre == null) return null;

        return switch (genre){
            case ACTION -> "Acción";
            case COMEDY -> "Comedia";
            case DRAMA -> "Drama";
            case FANTASY -> "Fantasía";
            case HORROR -> "Terror";
            case ROMANCE -> "Romance";
            case SCI_FI -> "Ciencia Ficción";
            case ANIMATED -> "Animación";
        };
    }

    @Named( "stringToGenre")
    public static Genre stringToGenre(String genre) {
        if (genre == null) return null;

        return switch (genre){
            case "Acción" -> Genre.ACTION;
            case "Comedia" -> Genre.COMEDY;
            case "Drama" -> Genre.DRAMA;
            case "Fantasía" -> Genre.FANTASY;
            case "Terror" -> Genre.HORROR;
            case "Romance" -> Genre.ROMANCE;
            case "Ciencia Ficción" -> Genre.SCI_FI;
            case "Animación" -> Genre.ANIMATED;
            default -> null;
        };
    }
}

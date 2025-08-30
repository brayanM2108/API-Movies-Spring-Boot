package com.melo_play.domain.exception;

public class MovieAlreadyExistException extends RuntimeException{

    public MovieAlreadyExistException(String movieTitle) {
        super("La película con titulo " + movieTitle + " ya existe");
    }
}

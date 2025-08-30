package com.melo_play.domain.exception;

public class MovieDoesNotExist extends RuntimeException{

    public MovieDoesNotExist(Long id) {
        super ("The movie with id " + id + " does not exist");
    }
}

package com.melo_play.web.exception;

import com.melo_play.domain.exception.MovieAlreadyExistException;
import com.melo_play.domain.exception.MovieDoesNotExist;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MovieAlreadyExistException.class)
    public ResponseEntity<Error> handleException (MovieAlreadyExistException ex) {
        Error error = new Error("MovieAlreadyExist", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MovieDoesNotExist.class)
    public ResponseEntity<Error> handleException (MovieDoesNotExist ex) {
        Error error = new Error("MovieDoesNotExist", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }
}

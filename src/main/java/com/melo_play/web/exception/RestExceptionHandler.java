package com.melo_play.web.exception;

import com.melo_play.domain.exception.MovieAlreadyExistException;
import com.melo_play.domain.exception.MovieDoesNotExist;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

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
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Error>> handleException (MethodArgumentNotValidException ex) {
        List<Error> errors = new ArrayList<>();

        ex.getBindingResult().getFieldErrors().forEach(fieldError -> errors.add(new Error(fieldError.getField(), fieldError.getDefaultMessage())));

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleException (Exception ex) {
        Error error = new Error("UnknownError", ex.getMessage());
        return ResponseEntity.internalServerError().body(error);
    }

}

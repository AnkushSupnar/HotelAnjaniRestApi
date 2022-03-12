package com.anjani.advice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.NoSuchElementException;

@ControllerAdvice
public class RestControllerAdvice {
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String>handleNoSuchElementException(NoSuchElementException noElementException){
        return new ResponseEntity<String>("No Value is Present in DB", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String>handleEntityNotFound(EntityNotFoundException notFound){
        return new ResponseEntity<String>("No Value is Present in DB", HttpStatus.BAD_REQUEST);
    }
}

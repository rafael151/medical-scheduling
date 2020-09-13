package com.challenge.eldorado.medical.scheduling.exceptions.handler;

import com.challenge.eldorado.medical.scheduling.exceptions.DoctorNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DoctorExceptionHandler {

    @ExceptionHandler({DoctorNotFoundException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleException(final DoctorNotFoundException e){
        return e.getMessage();
    }
}

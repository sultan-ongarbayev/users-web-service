package com.sultanongarbayev.userswebservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Exception handler which transforms any kind of exceptions to the {@link Response type} and send it to the client.
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> exceptionHandler(Exception e) {
        Response response = new Response();
        response.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setMessage("Server error occurred.");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

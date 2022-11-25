package com.springtour.travelbooking.controller;

import com.springtour.travelbooking.dto.ErrorResponse;
import com.springtour.travelbooking.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author : 조재철
 * @since 1.0
 */
@RestControllerAdvice
public class ApiExceptoinHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException ex) {
        System.out.println("Error Message : " + ex.getErrorMessage());

        return new ResponseEntity<>(
            new ErrorResponse(ex.getErrorMessage()),
            HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        return new ResponseEntity<>(
            new ErrorResponse("system error"),
            HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

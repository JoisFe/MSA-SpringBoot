package com.springtour.travelbooking.exception;

/**
 * @author : 조재철
 * @since 1.0
 */
public class BadRequestException extends RuntimeException {

    private final String errorMessage;

    public BadRequestException(String message, String errorMessage) {
        super(message);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

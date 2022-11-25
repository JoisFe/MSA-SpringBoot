package com.springtour.travelbooking.dto;

import lombok.Getter;
import lombok.ToString;

/**
 * @author : 조재철
 * @since 1.0
 */
@Getter
@ToString
public class ErrorResponse {

    private String errorMessage;

    public ErrorResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}

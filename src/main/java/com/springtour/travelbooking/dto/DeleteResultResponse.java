package com.springtour.travelbooking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : 조재철
 * @since 1.0
 */
@AllArgsConstructor
@Getter
public class DeleteResultResponse {

    private boolean success;
    private String message;
}

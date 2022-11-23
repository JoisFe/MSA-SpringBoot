package com.springtour.travelbooking.domain;

import java.util.Objects;
import lombok.Getter;

/**
 * @author : 조재철
 * @since 1.0
 */
@Getter
public class Hotel {

    private final Long hotelId;

    private final String name;

    private final String address;

    private final Integer roomCount;

    public Hotel(Long hotelId, String name, String address, Integer roomCount) {
        if (Objects.isNull(hotelId) || Objects.isNull(name) || Objects.isNull(address)) {
            throw new IllegalArgumentException("invalid hotel constraint");
        }

        if (Objects.isNull(roomCount) || roomCount <= 0) {
            throw new IllegalArgumentException("invalid room count");
        }

        this.hotelId = hotelId;
        this.name = name;
        this.address = address;
        this.roomCount = roomCount;
    }
}

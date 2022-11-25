package com.springtour.travelbooking.dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.ToString;

/**
 * @author : 조재철
 * @since 1.0
 */
@Getter
@ToString
public class HotelRoomReserveRequest {

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private String name;
}

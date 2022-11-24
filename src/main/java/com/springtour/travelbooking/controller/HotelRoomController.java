package com.springtour.travelbooking.controller;

import com.springtour.travelbooking.dto.HotelRoomResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : 조재철
 * @since 1.0
 */
@RestController
public class HotelRoomController {

    @GetMapping(path = "/hotels/{hotelId}/rooms/{roomNumber}")
    public HotelRoomResponse getHotelRoomByPeriod()
}

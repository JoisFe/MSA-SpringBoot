package com.springtour.travelbooking.service;

import com.springtour.travelbooking.domain.Hotel;
import org.springframework.stereotype.Service;

/**
 * @author : 조재철
 * @since 1.0
 */
@Service
public class HotelSearchService {

    public Hotel getHotelById(Long hotelId) {
        return new Hotel(hotelId,
            "The Continetal",
            "1 Wall St, New York, NY 10005",
            250);
    }
}

package com.springtour.travelbooking.service;

import java.time.LocalDate;
import org.springframework.stereotype.Service;

/**
 * @author : 조재철
 * @since 1.0
 */
@Service
public class ReserveService {

    public Long reserveHotelRoom(Long hotelId, String roomNumber, LocalDate checkInDate, LocalDate checkOutDate) {
        return 1_002_003_004L;
    }
}

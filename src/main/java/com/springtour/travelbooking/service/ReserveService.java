package com.springtour.travelbooking.service;

import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author : 조재철
 * @since 1.0
 */
@RequiredArgsConstructor
@Service
public class ReserveService {

    public Long reserveHotelRoom(Long hotelId, String roomNumber, LocalDate checkInDate, LocalDate checkOutDate) {
        //        hotelRoomRepository.findByHotelIdAndRoomNumber(hotelId, roomNumber)
//                .orElseThrow(() -> {
//                    log.error("Invalid roomNumber. hotelId:{}, roomNumber:{}", hotelId, roomNumber);
//                    return new BadRequestException("Not existing roomNumber");
//                });

        return 1_002_003_004L;
    }
}

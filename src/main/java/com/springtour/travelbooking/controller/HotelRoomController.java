package com.springtour.travelbooking.controller;

import com.springtour.travelbooking.domain.HotelRoomType;
import com.springtour.travelbooking.dto.DeleteResultResponse;
import com.springtour.travelbooking.dto.HotelRoomResponse;
import com.springtour.travelbooking.utils.IdGenerator;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : 조재철
 * @since 1.0
 */
@RestController
public class HotelRoomController {

    @GetMapping(path = "/hotels/{hotelId}/rooms/{roomNumber}")
    public HotelRoomResponse getHotelRoomByPeriod(@PathVariable Long hotelId, @PathVariable String roomNumber,
        @RequestParam(value = "fromDate", required = false) @DateTimeFormat(pattern = "yyyyMMdd")
            LocalDate fromDate,
        @RequestParam(value = "toDate", required = false) @DateTimeFormat(pattern = "yyyyMMdd") LocalDate toDate) {
        Long hotelRoomId = IdGenerator.create();
        BigDecimal originalPrice = new BigDecimal("130.00");

        HotelRoomResponse response = HotelRoomResponse.of(hotelRoomId, roomNumber, HotelRoomType.DOUBLE, originalPrice);

        if (Objects.nonNull(fromDate) && Objects.nonNull(toDate)) {
            fromDate.datesUntil(toDate.plusDays(1))
                    .forEach(response::reservedAt);
        }

        return response;
    }

    @DeleteMapping(path = "/hotels/{hotelId}/rooms/{roomNumber}")
    public DeleteResultResponse deleteHotelRoom(@PathVariable Long hotelId, @PathVariable String roomNumber) {
        System.out.println("Delete Request. hotelId=" + hotelId + ", roomNumber=" + roomNumber);

        return new DeleteResultResponse(Boolean.TRUE, "success");
    }
}

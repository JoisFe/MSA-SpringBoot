package com.springtour.travelbooking.controller;

import com.springtour.travelbooking.dto.HotelRoomIdResponse;
import com.springtour.travelbooking.dto.HotelRoomReserveRequest;
import com.springtour.travelbooking.service.ReserveService;
import com.springtour.travelbooking.validator.HotelRoomReserveValidator;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : 조재철
 * @since 1.0
 */
@RestController
public class HotelRoomReserveController {

    private final ReserveService reserveService;

    public HotelRoomReserveController(ReserveService reserveService) {
        this.reserveService = reserveService;
    }

    @InitBinder
    void initBinder(WebDataBinder binder) {
        binder.addValidators(new HotelRoomReserveValidator());
    }

    @PostMapping(path = "/hotels/{hotelId}/rooms/{roomNumber}/reserve")
    public ResponseEntity<HotelRoomIdResponse> reserveHotelRoomByRoomNumber(@PathVariable Long hotelId,
        @PathVariable String roomNumber, @Valid @RequestBody
        HotelRoomReserveRequest reserveRequest, BindingResult bindingResult) {
        Long reservationId = reserveService.reserveHotelRoom(hotelId, roomNumber, reserveRequest.getCheckInDate(),
            reserveRequest.getCheckOutDate());

        HotelRoomIdResponse body = HotelRoomIdResponse.from(reservationId);

        return ResponseEntity.ok(body);
    }
}

package com.springtour.travelbooking.controller;

import com.springtour.travelbooking.domain.Hotel;
import com.springtour.travelbooking.service.HotelSearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : 조재철
 * @since 1.0
 */
@Controller
public class HotelController {

    private final HotelSearchService hotelSearchService;

    public HotelController(HotelSearchService hotelSearchService) {
        this.hotelSearchService = hotelSearchService;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/hotels/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable("hotelId") Long hotelId) {
        Hotel hotel = hotelSearchService.getHotelById(hotelId);

        return ResponseEntity.ok(hotel);
    }
}

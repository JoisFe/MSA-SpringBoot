package com.springtour.travelbooking.controller;

import java.util.Collections;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : 조재철
 * @since 1.0
 */
@RestController
public class ReservationController {

    @GetMapping("/hotels/{hotelId}/rooms/{roomNumber}/reservations")
    public List<Long> getReservationsByPaging(@PathVariable Long hotelId, @PathVariable String roomNumber, Pageable pageable) {
        System.out.println("Page param : " + pageable.getPageNumber());
        System.out.println("Size param : " + pageable.getPageSize());

        pageable.getSort().stream().forEach(order -> {
            System.out.println("Sort param : " + order.getProperty() + " : " + order.getDirection());
        });

        return Collections.emptyList();
    }
}

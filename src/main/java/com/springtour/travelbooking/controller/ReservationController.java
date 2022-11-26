package com.springtour.travelbooking.controller;

import com.springtour.travelbooking.exception.FileDownloadException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
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
    public List<Long> getReservationsByPaging(@PathVariable Long hotelId, @PathVariable String roomNumber,
        Pageable pageable) {
        System.out.println("Page param : " + pageable.getPageNumber());
        System.out.println("Size param : " + pageable.getPageSize());

        pageable.getSort().stream().forEach(order -> {
            System.out.println("Sort param : " + order.getProperty() + " : " + order.getDirection());
        });

        return Collections.emptyList();
    }

    @GetMapping("/hotels/{hotelId}/rooms/{roomNumber}/reservations/{reservationId}")
    public ResponseEntity<byte[]> getInvoice(@PathVariable Long hotelId, @PathVariable String roomNumber,
        @PathVariable Long reservationId) {
        String filePath = "pdf/hotel_invoice.pdf";

        try (InputStream inputStream = new ClassPathResource(filePath).getInputStream()) {
            byte[] bytes = StreamUtils.copyToByteArray(inputStream);

            return new ResponseEntity<>(bytes, HttpStatus.OK);
        } catch (Throwable th) {
            th.printStackTrace();

            throw new FileDownloadException("file download error");
        }
    }
}

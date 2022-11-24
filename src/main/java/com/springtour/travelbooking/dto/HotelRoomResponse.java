package com.springtour.travelbooking.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.springtour.travelbooking.domain.HotelRoomType;
import com.springtour.travelbooking.serializer.ToDollarStringSerializer;
import com.springtour.travelbooking.utils.IdGenerator;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author : 조재철
 * @since 1.0
 */
@Getter
public class HotelRoomResponse {

    @JsonProperty("id")
    @JsonSerialize(using = ToStringSerializer.class)
    private final Long hotelRoomId;

    private final String roomNumber;

    private final HotelRoomType hotelRoomType;

    @JsonSerialize(using = ToDollarStringSerializer.class)
    private final BigDecimal originalPrice;

    private final List<Reservation> resrvations;

    private HotelRoomResponse(Long hotelRoomId, String roomNumber, HotelRoomType hotelRoomType, BigDecimal originalPrice) {
        this.hotelRoomId = hotelRoomId;
        this.roomNumber = roomNumber;
        this.hotelRoomType = hotelRoomType;
        this.originalPrice = originalPrice;
        this.resrvations = new ArrayList<>();
    }

    public static HotelRoomResponse of (Long hotelRoomId, String roomNumber, HotelRoomType hotelRoomType, BigDecimal originalPrice) {
        return new HotelRoomResponse(hotelRoomId, roomNumber, hotelRoomType, originalPrice);
    }

    public void reservedAt(LocalDate reservedAt) {
        this.resrvations.add(new Reservation(IdGenerator.create(), reservedAt));
    }

    @Getter
    @RequiredArgsConstructor
    private static class Reservation {

        @JsonProperty("id")
        @JsonSerialize(using = ToStringSerializer.class)
        private final Long reservationId;

        @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
        private final LocalDate reservedDate;
    }
}

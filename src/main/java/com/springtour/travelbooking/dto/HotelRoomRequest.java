package com.springtour.travelbooking.dto;

import com.springtour.travelbooking.domain.HotelRoomType;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.ToString;

/**
 * @author : 조재철
 * @since 1.0
 */
@Getter
@ToString
public class HotelRoomRequest {

    private String roomNumber;
    private HotelRoomType roomType;
    private BigDecimal originalPrice;
}

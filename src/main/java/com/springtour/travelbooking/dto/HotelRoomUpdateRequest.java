package com.springtour.travelbooking.dto;

import com.springtour.travelbooking.domain.HotelRoomType;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;

/**
 * @author : 조재철
 * @since 1.0
 */
@Getter
@ToString
public class HotelRoomUpdateRequest {

    @NotNull(message = "roomType can't be null")
    private HotelRoomType hotelRoomType;

    @NotNull(message = "originalPrice can't be null")
    @Min(value = 0, message = "originalPrice must be larger than 0")
    private BigDecimal originalPrice;
}

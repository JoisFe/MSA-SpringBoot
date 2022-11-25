package com.springtour.travelbooking.validator;

import com.springtour.travelbooking.dto.HotelRoomReserveRequest;
import java.util.Objects;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


/**
 * @author : 조재철
 * @since 1.0
 */
public class HotelRoomReserveValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return HotelRoomReserveRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        HotelRoomReserveRequest request = (HotelRoomReserveRequest) target;

        if (Objects.isNull(request.getCheckInDate())) {
            errors.rejectValue("checkInDate", "NotNull", "checkInDate is null");
        }

        if (Objects.isNull(request.getCheckOutDate())) {
            errors.rejectValue("checkOutDate", "NotNull", "checkOutDate is null");
        }

        if (request.getCheckInDate().compareTo(request.getCheckOutDate()) >= 0) {
            errors.rejectValue("checkOutDate", "Constraint Error", "checkOutDate is earlier than checkInDate");

            return;
        }
    }
}

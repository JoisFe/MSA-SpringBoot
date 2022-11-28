package com.springtour.travelbooking.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : 조재철
 * @since 1.0
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi groupedOpenApi() {
        return GroupedOpenApi.builder()
            .group("v1-definition")
            .pathsToMatch("/**")
            .build();
    }

    @Bean
    public OpenAPI springHotelBookingApi() {
        return new OpenAPI()
            .info(new Info().title("Hotel Booking API")
            .description("호텔 객실 예약 프로젝트 API 명세서")
            .version("v0.0.1"));
    }

}

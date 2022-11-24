package com.springtour.travelbooking.utils;

import java.util.Random;

/**
 * @author : 조재철
 * @since 1.0
 */
public class IdGenerator {

    private static final Integer bound = 10000;

    public static Long create() {
        Random random = new Random();

        return System.currentTimeMillis() * bound + random.nextInt(bound);
    }
}

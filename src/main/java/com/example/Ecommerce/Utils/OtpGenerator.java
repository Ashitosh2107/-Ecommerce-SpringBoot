package com.example.Ecommerce.Utils;

import java.security.SecureRandom;

public class OtpGenerator {

    private static final SecureRandom secureRandom = new SecureRandom();

    private OtpGenerator() {
    }

    public static String generateOtp() {
        return String.valueOf(100000 + secureRandom.nextInt(900000));
    }
}
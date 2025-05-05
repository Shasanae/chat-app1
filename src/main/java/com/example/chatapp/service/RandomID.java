package com.example.chatapp.service;

import java.security.SecureRandom;

public class RandomID {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generateRandomId(int length) {
        StringBuilder id = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            id.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return id.toString();
    }
}

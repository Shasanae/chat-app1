package com.example.chatapp.service;

import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtils {

    // Kiểu Date
    public static Date getCurrentDate() {
        return new Date();
    }

    // Kiểu LocalDateTime
    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }

    // Trả về dạng String yyyy-MM-dd HH:mm:ss
    public static String getFormattedCurrentTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return getCurrentDateTime().format(formatter);
    }

}

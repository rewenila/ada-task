package br.com.ada.adatask.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public interface InputValidator {

    static boolean validateDate(String dateString) {
        try {
            LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return true;
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format, please try again.");
            return false;
        }
    }

    static boolean validateTime(String timeString) {
        try {
            LocalTime.parse(timeString, DateTimeFormatter.ofPattern("HH:mm"));
            return true;
        } catch (DateTimeParseException e) {
            System.out.println("Invalid time format, please try again.");
            return false;
        }
    }

}

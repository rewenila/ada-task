package br.com.ada.adatask.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TimeValidator implements Validator<LocalTime>{

    @Override
    public boolean validate(LocalTime providedTime) {
        LocalTime currentTime = LocalTime.now();
        return providedTime.isAfter(currentTime);
    }

}

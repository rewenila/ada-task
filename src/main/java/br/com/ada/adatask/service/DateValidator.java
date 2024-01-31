package br.com.ada.adatask.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidator implements Validator<LocalDate>{

    @Override
    public boolean validate(LocalDate providedDate) {
        LocalDate currentDate = LocalDate.now();
        return providedDate.isAfter(currentDate);
    }

}

package br.com.ada.adatask.controller;

public interface DateTimeFormatValidator {

    boolean isValidDate(String dateString);
    boolean isValidTime(String timeString);

}

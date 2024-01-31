package br.com.ada.adatask.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public interface Task {

    Integer getId();
    String getTitle();
    String getDescription();
    LocalDate getDate();
    LocalTime getTime();


    void setTitle(String title);
    void setDescription(String description);
    void setDate(LocalDate date);
    void setTime(LocalTime time);

    public String toString();

}

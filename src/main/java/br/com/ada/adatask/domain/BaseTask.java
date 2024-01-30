package br.com.ada.adatask.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class BaseTask implements Task {

    private Integer id;
    private static Integer nextId = 1;
    private String title;
    private String description;
    private LocalDate date;
    private LocalTime time;

    public BaseTask(String title, String description, LocalDate date, LocalTime time) {
        this.id = nextId;
        nextId++;

        this.title = title;
        this.description = description;
        this.date = date;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Task " + id + "\n" +
                "- Type: Regular Task\n" +
                "- Title: " + title + "\n" +
                "- Description: " + description + "\n" +
                "- Date: " + date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n" +
                "- Time: " + time.format(DateTimeFormatter.ofPattern("HH:mm")) + "\n";
    }

}

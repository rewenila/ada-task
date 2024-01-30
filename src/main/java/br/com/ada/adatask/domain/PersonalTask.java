package br.com.ada.adatask.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class PersonalTask extends BaseTask {

    private String category;

    public PersonalTask(String title, String description, LocalDate date, LocalTime time, String category) {
        super(title, description, date, time);
        this.category = category;
    }

    @Override
    public Integer getId() {
        return super.getId();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Task: " + super.getId() + "\n" +
                "- Type: Personal Task\n" +
                "- Title: " + super.getTitle() + "\n" +
                "- Description: " + super.getDescription() + "\n" +
                "- Date: " + super.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n" +
                "- Time: " + super.getTime().format(DateTimeFormatter.ofPattern("HH:mm")) + "\n" +
                "- Category: " + category + "\n";
    }

}

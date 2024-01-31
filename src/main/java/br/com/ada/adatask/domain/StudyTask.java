package br.com.ada.adatask.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class StudyTask extends BaseTask {

    private String subject;

    public StudyTask(String title, String description, LocalDate date, LocalTime time, String subject) {
        super(title, description, date, time);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Task " + super.getId() + "\n" +
                "- Type: Study Task\n" +
                "- Title: " + super.getTitle() + "\n" +
                "- Description: " + super.getDescription() + "\n" +
                "- Date: " + super.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n" +
                "- Time: " + super.getTime().format(DateTimeFormatter.ofPattern("HH:mm")) + "\n" +
                "- Subject: " + subject + "\n";
    }
}

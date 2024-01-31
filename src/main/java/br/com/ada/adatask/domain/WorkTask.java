package br.com.ada.adatask.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class WorkTask extends BaseTask {

    private String project;
    public WorkTask(String title, String description, LocalDate date, LocalTime time, String project) {
        super(title, description, date, time);
        this.project = project;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "Task " + super.getId() + "\n" +
                "- Type: Work Task\n" +
                "- Title: " + super.getTitle() + "\n" +
                "- Description: " + super.getDescription() + "\n" +
                "- Date: " + super.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n" +
                "- Time: " + super.getTime().format(DateTimeFormatter.ofPattern("HH:mm")) + "\n" +
                "- Project: " + project + "\n";
    }
}
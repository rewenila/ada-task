package br.com.ada.adatask.domain;

import java.time.LocalDateTime;

public class WorkTask extends BaseTask {

    private String project;
    public WorkTask(String title, String description, String deadline, String project) {
        super(title, description, deadline);
        this.project = project;
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    @Override
    public String getDecription() {
        return super.getDecription();
    }

    @Override
    public String getDeadline() {
        return super.getDeadline();
    }

    public String getProject() {
        return project;
    }

    @Override
    public String toString() {
        return "WorkTask{" +
                "project='" + project + '\'' +
                "} " + super.toString();
    }
}
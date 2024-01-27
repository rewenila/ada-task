package br.com.ada.adatask.domain;

import java.time.LocalDateTime;

public class StudyTask extends BaseTask {

    private String subject;

    public StudyTask(String title, String description, String deadline, String subject) {
        super(title, description, deadline);
        this.subject = subject;
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

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "StudyTask{" +
                "subject='" + subject + '\'' +
                "} " + super.toString();
    }

}

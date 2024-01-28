package br.com.ada.adatask.domain;

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
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public String getDeadline() {
        return super.getDeadline();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return super.getId() + ": Study Task; " +
                "Title: " + super.getTitle() + ", " +
                "Description: " + super.getDescription() + ", " +
                "Deadline: " + super.getDeadline() + ", " +
                "Subject: " + subject;
    }
}

package br.com.ada.adatask.domain;

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
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public String getDeadline() {
        return super.getDeadline();
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return super.getId() + ": Work Task; " +
                "Title: " + super.getTitle() + ", " +
                "Description: " + super.getDescription() + ", " +
                "Deadline: " + super.getDeadline() + ", " +
                "Project: " + project;
    }
}
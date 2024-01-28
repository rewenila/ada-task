package br.com.ada.adatask.domain;

public class BaseTask implements Task {

    private Long id;
    private static Long nextId = 1L;
    private String title;
    private String description;
    private String deadline;

    public BaseTask(String title, String description, String deadline) {
        this.id = nextId;
        nextId++;

        this.title = title;
        this.description = description;
        this.deadline = deadline;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return id + ": Regular Task; " +
                "Title: " + title + ", " +
                "Description: " + description + ", " +
                "Deadline: " + deadline;
    }

}

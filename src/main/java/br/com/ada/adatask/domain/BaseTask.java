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

    @Override
    public String toString() {
        return "BaseTask{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}

package br.com.ada.adatask.domain;

import java.time.LocalDateTime;

public class BaseTask implements Task {
    private String title;
    private String description;
    private String deadline;

    public BaseTask(String title, String description, String deadline) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
    }

    public String getTitle() {
        return title;
    }

    public String getDecription() {
        return description;
    }

    public String getDeadline() {
        return deadline;
    }

    @Override
    public String toString() {
        return "BaseTask{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}

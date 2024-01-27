package br.com.ada.adatask.domain;

public class PersonalTask extends BaseTask {

    private String category;

    public PersonalTask(String title, String description, String deadline, String category) {
        super(title, description, deadline);
        this.category = category;
    }

    @Override
    public Long getId() {
        return super.getId();
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

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "PersonalTask{" +
                "category='" + category + '\'' +
                "} " + super.toString();
    }

}

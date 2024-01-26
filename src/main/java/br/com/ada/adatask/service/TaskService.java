package br.com.ada.adatask.service;

import br.com.ada.adatask.domain.Task;
import br.com.ada.adatask.repository.Repository;

public class TaskService {

    private final Repository repository;

    public TaskService(Repository repository) {
        this.repository = repository;
    }

    public void saveNewTask(Task task) {
        System.out.println("Saving task in repository " + this.repository.getClass().getName());
        repository.create(task);
    }
}

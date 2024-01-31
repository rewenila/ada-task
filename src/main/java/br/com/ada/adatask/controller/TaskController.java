package br.com.ada.adatask.controller;

import br.com.ada.adatask.domain.Task;

public interface TaskController<T extends Task> {

    void listTasks();
    void createTask();
    void updateTask(Integer id);
    void deleteTask();

}

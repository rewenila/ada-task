package br.com.ada.adatask.service;

import br.com.ada.adatask.domain.Task;

import java.util.List;

public interface TaskService<T> {

    void createTask(T t);
    void updateTask(T t);
    void deleteTask(Integer id);
    public List<T> getAllTasks();
    public T getTaskById(Integer id);
    public <T extends Task> List<T> filterTasksByType(Class<T> taskType);
}

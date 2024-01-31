package br.com.ada.adatask.service;

import br.com.ada.adatask.domain.Task;

import java.util.List;

public interface TaskService<T> {

    boolean createTask(T t);
    boolean updateTask(T t);
    void deleteTask(Integer id);
    public List<T> getAllTasks();
    public T getTaskById(Integer id);
    public List<T> filterTasksByType(Class<? extends Task> taskType);
}

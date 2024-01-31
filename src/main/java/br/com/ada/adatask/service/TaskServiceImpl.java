package br.com.ada.adatask.service;

import br.com.ada.adatask.domain.BaseTask;
import br.com.ada.adatask.domain.Task;
import br.com.ada.adatask.repository.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TaskServiceImpl<T extends Task> implements TaskService<T> {

    private final Repository<T> repository;

    public TaskServiceImpl(Repository<T> repository) {
        this.repository = repository;
    }

    @Override
    public boolean createTask(T task) {
        if (isInFuture(task) && isNotOverlapping(task)) {
            repository.save(task);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateTask(T task) {
        if (isInFuture(task) && isNotOverlapping(task)) {
            repository.update(task);
            return true;
        }
        else return false;
    }

    @Override
    public void deleteTask(Integer id) {
        T task = repository.getById(id);
        repository.delete(task);
    }

    @Override
    public List<T> getAllTasks() {
        return repository.getAll();
    }

    @Override
    public T getTaskById(Integer id) {
        return repository.getById(id);
    }

    @Override
    public List<T> filterTasksByType(Class<? extends Task> taskType) {
        List<T> allTasks = repository.getAll();
        List<T> filteredTasks = new ArrayList<>();

        for (T task : allTasks) {
            if (task.getClass().equals(taskType)) {
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }

    public boolean isInFuture(T newTask) {
        LocalDate date = newTask.getDate();
        LocalTime time = newTask.getTime();
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();

        if (date.isBefore(currentDate) || (date.equals(currentDate) && time.isBefore(currentTime))) {
            System.out.println("It is not possible to register tasks with a past date and time.");
            return false;
        }

        return true;
    }

    public boolean isNotOverlapping(T newTask) {
        LocalDate date = newTask.getDate();
        LocalTime time = newTask.getTime();

        List<T> tasks = getAllTasks();

        for (T task: tasks) {
            if (task.getDate().equals(date) && task.getTime().equals(time)) {
                System.out.println("It is not possible to schedule two tasks for the same date and time.");
                return false;
            }
        }
        return true;
    }

}

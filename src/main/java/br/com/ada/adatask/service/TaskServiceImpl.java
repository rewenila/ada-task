package br.com.ada.adatask.service;

import br.com.ada.adatask.domain.Task;
import br.com.ada.adatask.repository.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskServiceImpl<T extends Task> implements TaskService<T> {

    private final Repository<T> repository;

    public TaskServiceImpl(Repository<T> repository) {
        this.repository = repository;
    }

    @Override
    public void createTask(T task) {
        repository.save(task);
    }

    @Override
    public void updateTask(T task) {
        repository.update(task);
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

    // Todo: implement logic to return a task only for its own class and not for
    //  its superclass
    public <T extends Task> List<T> filterTasksByType(Class<T> taskType) {
        List<T> allTasks = (List<T>) repository.getAll();
        List<T> filteredTasks = new ArrayList<>();

        for (Task task : allTasks) {
            if (taskType.isInstance(task)) {
                filteredTasks.add(taskType.cast(task));
            }
        }
        return filteredTasks;
    }

}

package br.com.ada.adatask.service;

import br.com.ada.adatask.domain.BaseTask;
import br.com.ada.adatask.domain.Task;
import br.com.ada.adatask.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class TaskService {

    private final Repository repository;

    public TaskService(Repository repository) {
        this.repository = repository;
    }

    public void createTask(Task task) {
        System.out.println("Saving task in repository " + this.repository.getClass().getName());
        repository.save(task);
    }

    public void updateTask(BaseTask existingTask, BaseTask newTask) {
        System.out.println("Editing task " + existingTask.getTitle());
        repository.delete(existingTask);
        repository.save(newTask);
    }

    public void deleteTask(Task task) {
        System.out.println("Deleting task " + task.toString());
        repository.delete(task);
    }

    public List<Task> getAllTasks() {
        return repository.getAll();
    }

    public Task getTaskById(Long id) {
        List<Task> allTasks = repository.getAll();

        for(Task task : allTasks) {
            if (id.equals(task.getId())) {
                return task;
            }
        }

        return null;
    }

    public <T extends Task> List<T> filterByTaskType(Class<T> taskType) {
        List<Task> allTasks = repository.getAll();
        List<T> filteredTasks = new ArrayList<>();

        for (Task task : allTasks) {
            if (taskType.isInstance(task)) {
                filteredTasks.add(taskType.cast(task));
            }
        }

        return filteredTasks;
    }

}

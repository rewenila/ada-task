package br.com.ada.adatask.repository;

import br.com.ada.adatask.domain.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository<T extends Task> implements Repository<T>{

    private List<T> tasks;

    public TaskRepository() {
        this.tasks = new ArrayList<>();
    }

    @Override
    public void save(T task) {
        tasks.add(task);
    }

    @Override
    public void edit(T task) {
        // Todo
    }

    @Override
    public void delete(T task) {
        tasks.remove(task);
    }

    @Override
    public List<T> getAll() {
        return tasks;
    }

/*    @Override
    public List<T> getByType(T type) {

        for (T task : tasks) {

        }
        return null;
    }*/

    /*public Task teste(Long id) {

        for (Task task : tasks) {
            if (id.equals(task.getId())) {
                return task;
            }
        }
        return null;

    }

    public Task getById(List<Task> tasks, Long id) {
        for (Task task : tasks) {
            if (id.equals(task.getId())) {
                return task;
            }
        }
        return null;
    }*/

    /*public <T extends Task> List<T> filterByType(Class<T> taskType) {
        List<T> filteredTasks = new ArrayList<>();

        for (Task task : tasks) {
            if (taskType.isInstance(task)) {
                filteredTasks.add(taskType.cast(task));
            }
        }

        return filteredTasks;
    }*/

/*    public <T extends Task> List<T> filterByType(List<Task> tasks, Class<T> taskType) {
        List<T> filteredTasks = new ArrayList<>();

        for (Task task : tasks) {
            if (taskType.isInstance(task)) {
                filteredTasks.add(taskType.cast(task));
            }
        }

        return filteredTasks;
    }*/
}

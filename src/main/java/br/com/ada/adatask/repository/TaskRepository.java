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
    public void update(T task) {
        Integer index = getIndexById(task.getId());
        tasks.set(index, task);
    }

    @Override
    public void delete(T task) {
        // todo: check if task exists
        tasks.remove(task);
    }

    @Override
    public List<T> getAll() {
        return tasks;
    }

    @Override
    public T getById(Integer id) {
        Integer index = getIndexById(id);
        if (index != null) {
            return tasks.get(index);
        }
        // Todo: add exception here or in service?
        return null;
    }

    public Integer getIndexById(Integer id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (id.equals(tasks.get(i).getId())) {
                return i;
            }
        }
        return null;
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

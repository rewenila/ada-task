package br.com.ada.adatask.repository;

import br.com.ada.adatask.domain.BaseTask;
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
        return new ArrayList<>(tasks);
    }

    @Override
    public List<T> getByType(T type) {

        for (T task : tasks) {
            // Todo
        }
        return null;
    }
}

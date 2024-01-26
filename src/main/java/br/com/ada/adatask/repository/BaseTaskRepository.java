package br.com.ada.adatask.repository;

import br.com.ada.adatask.domain.BaseTask;
import br.com.ada.adatask.domain.Task;

public class BaseTaskRepository implements Repository<Task>{
    @Override
    public void save(Task task) {
        // Todo: implement method
        System.out.println("Creating new task");
    }

    @Override
    public void edit(Task task) {
        // Todo: implement method
        System.out.println("Editing task");
    }

    @Override
    public void delete(Task task) {
        // Todo: implement method
        System.out.println("Deleting task");
    }

    @Override
    public void list(Task task) {
        // Todo: implement method
        // Todo: create filters and pass as argument here
        System.out.println("Listing tasks");
    }
}

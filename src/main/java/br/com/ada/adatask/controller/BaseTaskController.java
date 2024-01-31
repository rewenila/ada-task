package br.com.ada.adatask.controller;

import br.com.ada.adatask.domain.*;
import br.com.ada.adatask.service.TaskService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class BaseTaskController implements TaskController<BaseTask> {
    protected final TaskService<Task> service;
    private final Scanner scanner;

    public BaseTaskController(TaskService<Task> service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void listTasks() {
        List<BaseTask> tasks = service.filterTasksByType(BaseTask.class);

        if (tasks.isEmpty()) {
            System.out.println("The list of Regular tasks is empty.");
            return;
        }

        System.out.println("Listing Regular tasks...\n");
        for (BaseTask task : tasks) {
            System.out.println(task.toString());
        }
    }

    @Override
    public void createTask() {
        System.out.println("Task title: ");
        String title = scanner.nextLine();

        System.out.println("Task description: ");
        String description = scanner.nextLine();

        LocalDate date = null;
        boolean isValidDate;
        do {
            System.out.println("Task date (dd/MM/yyyy): ");
            String dateString = scanner.nextLine();

            isValidDate = InputValidator.validateDate(dateString);

            if (isValidDate) {
                date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            }
        } while (!isValidDate);


        LocalTime time = null;
        boolean isValidTime;
        do {
            System.out.println("Task time (HH:mm): ");
            String timeString = scanner.nextLine();

            isValidTime = InputValidator.validateTime(timeString);

            if (isValidTime) {
                time = LocalTime.parse(timeString, DateTimeFormatter.ofPattern("HH:mm"));
            }
        } while (!isValidTime);

        service.createTask(new BaseTask(title, description, date, time));
        System.out.println("Regular task successfully created.");

    }

    @Override
    public void updateTask(Integer id) {
        BaseTask task = (BaseTask) service.getTaskById(id);

        System.out.println("New task title: ");
        task.setTitle(scanner.nextLine());

        System.out.println("New task description: ");
        task.setDescription(scanner.nextLine());

        boolean isValidDate;
        do {
            System.out.println("New task date (dd/MM/yyyy): ");
            String dateString = scanner.nextLine();

            isValidDate = InputValidator.validateDate(dateString);

            if (isValidDate) {
                task.setDate(LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            }
        } while (!isValidDate);

        boolean isValidTime;
        do {
            System.out.println("New task time (HH:mm): ");
            String timeString = scanner.nextLine();

            isValidTime = InputValidator.validateTime(timeString);

            if (isValidTime) {
                task.setTime(LocalTime.parse(timeString, DateTimeFormatter.ofPattern("HH:mm")));
            }
        } while (!isValidTime);

        service.updateTask(task);
        System.out.println("Regular task successfully updated.");
    }

    @Override
    public void deleteTask() {
        System.out.println("Please inform the task id: ");
        Integer id = scanner.nextInt(); scanner.nextLine();

        if (service.getTaskById(id) == null) {
            System.out.println("Task not found for id " + id);
            return;
        }

        service.deleteTask(id);
        System.out.println("Regular task successfully deleted.");
    }

}

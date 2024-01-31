package br.com.ada.adatask.controller;

import br.com.ada.adatask.domain.BaseTask;
import br.com.ada.adatask.domain.PersonalTask;
import br.com.ada.adatask.domain.Task;
import br.com.ada.adatask.service.TaskService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class PersonalTaskController implements TaskController<PersonalTask> {
    protected final TaskService<Task> service;
    private final Scanner scanner;

    public PersonalTaskController(TaskService<Task> service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void listTasks() {
        List<Task> tasks = service.filterTasksByType(PersonalTask.class);

        if (tasks.isEmpty()) {
            System.out.println("The list of Personal tasks is empty.\n");
            return;
        }

        System.out.println("                       Personal task list                      ");
        System.out.println("---------------------------------------------------------------");
        for (Task task : tasks) {
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

        System.out.println("Task category: ");
        String category = scanner.nextLine();

        if (service.createTask(new PersonalTask(title, description, date, time, category))) {
            System.out.println("Personal task successfully created.");
        } else {
            System.out.println("It was not possible to create the task, please try again.");
        }
    }

    @Override
    public void updateTask(Integer id) {
        PersonalTask task = (PersonalTask) service.getTaskById(id);

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

        System.out.println("New task category: ");
        task.setCategory(scanner.nextLine());

        if (service.updateTask(task)) {
            System.out.println("Regular task successfully updated.");
        } else {
            System.out.println("It was not possible to update the task.");
        }
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
        System.out.println("Personal task successfully deleted.");
    }
}
package br.com.ada.adatask.controller;

import br.com.ada.adatask.domain.StudyTask;
import br.com.ada.adatask.domain.Task;
import br.com.ada.adatask.service.TaskService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class StudyTaskController implements TaskController<StudyTask>{

    protected final TaskService<Task> service;
    private final Scanner scanner;

    public StudyTaskController(TaskService<Task> service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void listTasks() {
        List<StudyTask> tasks = service.filterTasksByType(StudyTask.class);

        if (tasks.isEmpty()) {
            System.out.println("The list of Study tasks is empty.");
            return;
        }

        System.out.println("Listing Study tasks...\n");
        for (StudyTask task : tasks) {
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

        System.out.println("Task subject: ");
        String subject = scanner.nextLine();

        service.createTask(new StudyTask(title, description, date, time, subject));
        System.out.println("Study task successfully created.");

    }

    @Override
    public void updateTask(Integer id) {
        StudyTask task = (StudyTask) service.getTaskById(id);

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

        System.out.println("New task subject: ");
        task.setSubject(scanner.nextLine());

        service.updateTask(task);
        System.out.println("Study task successfully updated.");
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
        System.out.println("Study task successfully deleted.");
    }
}


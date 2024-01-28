package br.com.ada.adatask.controller;

import br.com.ada.adatask.domain.*;
import br.com.ada.adatask.service.TaskService;

import java.util.List;
import java.util.Scanner;

public class TaskController {

    private final TaskService service;
    private final Scanner scanner;

    public TaskController(TaskService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void showListTasksMenu() {
        Scanner scanner = new Scanner(System.in);

        int option;
        do {
            System.out.println();
            System.out.println("List tasks menu");
            System.out.println("1: List all tasks");
            System.out.println("2: List tasks by type");
            System.out.println("3: List tasks by deadline");
            System.out.println("4: Go back to main menu");
            System.out.println("Please inform your option: ");

            option = scanner.nextInt(); scanner.nextLine();

            System.out.println();

            switch (option) {
                case 1:
                    printAllTasks();
                    break;
                case 2:
                    showListTasksByTypeMenu();
                    break;
                case 3:
                    showListTasksByDeadlineMenu();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("There is no such option, please try again.");
                    break;
            }
        } while (option != 4);

        //scanner.close();
    }

    public void showListTasksByTypeMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("These are the available task types:");
        System.out.println("1 - Regular, 2 - Personal, 3 - Study, 4 - Work");
        System.out.println("Please inform the desired type:");

        int type = scanner.nextInt(); scanner.nextLine();

        System.out.println();

        switch (type) {
            case 1:
                printTasksByType(BaseTask.class, "Regular");
                break;
            case 2:
                printTasksByType(PersonalTask.class, "Personal");
                break;
            case 3:
                printTasksByType(StudyTask.class, "Study");
                break;
            case 4:
                printTasksByType(WorkTask.class, "Work");
                break;
            default:
                System.out.println("There is no such type, please try again.");
                break;
        }

        //scanner.close();
    }

    public void showListTasksByDeadlineMenu() {
        // today, tomorrow, next 7 days, next 30 days
    }

    public void showCreateTaskMenu() {

        System.out.println("To create a new task, please inform the following:");
        System.out.println("Task type: ");
        System.out.println("These are the available task types:");
        System.out.println("1 - Regular, 2 - Personal, 3 - Study, 4 - Work");
        int type = scanner.nextInt(); scanner.nextLine();
        System.out.println("Task title: ");
        String title = scanner.nextLine();
        System.out.println("Task description: ");
        String description = scanner.nextLine();
        System.out.println("Task deadline (DD/MM/YYYY): ");
        String deadline = scanner.nextLine();

        // todo: create type specific controllers and delegate depending on type
        switch (type) {
            case 1:
                service.createTask(new BaseTask(title,description,deadline));
                break;
            case 2:
                System.out.println("Task category: ");
                String category = scanner.nextLine();
                service.createTask(new PersonalTask(title,description,deadline,category));
                break;
            case 3:
                System.out.println("Task subject: ");
                String subject = scanner.nextLine();
                service.createTask(new StudyTask(title,description,deadline,subject));
                break;
            case 4:
                System.out.println("Task project: ");
                String project = scanner.nextLine();
                service.createTask(new StudyTask(title,description,deadline,project));
                break;
        }
    }

    public void showUpdateTitleMenu(BaseTask task) {
        System.out.println("Please inform the following:");
        System.out.println("New task title: ");
        String title = scanner.nextLine();

        service.updateTask(task,new BaseTask(title,task.getDescription(),task.getDeadline()));
    }

    public void showUpdateDescriptionMenu(BaseTask task) {
        System.out.println("Please inform the following:");
        System.out.println("New task description: ");
        String description = scanner.nextLine();

        service.updateTask(task,new BaseTask(task.getTitle(),description,task.getDeadline()));
    }

    public void showUpdateDeadlineMenu(BaseTask task) {
        System.out.println("Please inform the following:");
        System.out.println("New task deadline (DD/MM/YYYY): ");
        String deadline = scanner.nextLine();

        service.updateTask(task,new BaseTask(task.getTitle(),task.getDescription(),deadline));
    }

    public void showCreateConfirmation(String title) {
        System.out.println("Task " + title + " was successfully created.");
    }

    public void showUpdateConfirmation(String title) {
        System.out.println("Task " + title + " was successfully updated.");
    }

    public void showDeleteConfirmation(String title) {
        System.out.println("Task " + title + " was successfully deleted.");
    }

    public void printAllTasks() {
        List<Task> allTasks = service.getAllTasks();

        System.out.println("Showing all tasks:");
        for (Task task : allTasks) {
            System.out.println(task.toString());
        }
    }

    public void printTasksByType(Class taskType, String taskTypeString) {
        List<Task> filteredTasks = service.filterByTaskType(taskType);

        System.out.println("Showing " + taskTypeString + " Tasks:");
        for (Task task: filteredTasks) {
            System.out.println(task.toString());
        }
    }
}

package br.com.ada.adatask.controller;

import br.com.ada.adatask.domain.*;
import br.com.ada.adatask.service.TaskService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class BaseTaskController implements TaskController, DateTimeFormatValidator {

    protected final TaskService<Task> service;
    private final Scanner scanner;

    public BaseTaskController(TaskService<Task> service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void showListTasksMenu() {

        System.out.println("------------------------------------------------");
        System.out.println("                 List tasks menu                ");
        System.out.println("------------------------------------------------");

        int option;
        do {
            System.out.println();
            System.out.println("1: List all tasks");
            System.out.println("2: List tasks of one type");
            System.out.println("3: List tasks by deadline");
            System.out.println("4: Go back to main menu");
            System.out.println();
            System.out.println("Please inform your option: ");

            option = scanner.nextInt(); scanner.nextLine();

            System.out.println();

            switch (option) {
                case 1:
                    printTasks();
                    break;
                case 2:
                    showListTasksByTypeMenu();
                    break;
                case 3:
                    showListTasksByDeadlineMenu();
                    break;
                case 4:
                    System.out.println("Going back to main menu...");
                    break;
                default:
                    System.out.println("There is no such option, please try again.");
                    break;
            }
        } while (option != 4);
    }

    @Override
    public void showCreateTaskMenu() {

        System.out.println("------------------------------------------------");
        System.out.println("                 Create task menu               ");
        System.out.println("------------------------------------------------");
        System.out.println();
        System.out.println("To create a new task, please inform the following:");

        int type = 0;
        boolean isValidType = false;
        do {
            System.out.println("Task type: ");
            System.out.println("These are the available task types:");
            System.out.println("1 - Regular, 2 - Personal, 3 - Study, 4 - Work");
            type = scanner.nextInt();
            scanner.nextLine();

            if (type >= 1 && type <= 4) {
                isValidType = true;
            } else {
                System.out.println("Invalid task type. Please try again.");
                System.out.println();
            }
        } while (!isValidType);

        System.out.println("Task title: ");
        String title = scanner.nextLine();

        System.out.println("Task description: ");
        String description = scanner.nextLine();

        LocalDate date = null;
        boolean isValidDate = false;
        do {
            System.out.println("Task date (dd/MM/yyyy): ");
            String dateString = scanner.nextLine();

            isValidDate = isValidDate(dateString);
            if (isValidDate) {
                date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } else {
                System.out.println("Invalid date format, please try again.");
            }
        } while (!isValidDate);

        LocalTime time = null;
        boolean isValidTime = false;
        do {
            System.out.println("Task time (HH:mm): ");
            String timeString = scanner.nextLine();
            System.out.println(timeString);

            isValidTime = isValidTime(timeString);
            if (isValidTime) {
                time = LocalTime.parse(timeString, DateTimeFormatter.ofPattern("HH:mm"));
            } else {
                System.out.println("Invalid time format, please try again.");
            }
        } while (!isValidTime);

        // todo: create type specific controllers and delegate depending on type
        switch (type) {
            case 1:
                service.createTask(new BaseTask(title, description, date, time));
                System.out.println("Task successfully created.");
                break;
            case 2:
                System.out.println("Task category: ");
                String category = scanner.nextLine();
                service.createTask(new PersonalTask(title, description, date, time, category));
                System.out.println("Task successfully created.");
                break;
            case 3:
                System.out.println("Task subject: ");
                String subject = scanner.nextLine();
                service.createTask(new StudyTask(title ,description, date, time, subject));
                System.out.println("Task successfully created.");
                break;
            case 4:
                System.out.println("Task project: ");
                String project = scanner.nextLine();
                service.createTask(new StudyTask(title, description, date, time, project));
                System.out.println("Task successfully created.");
                break;
        }
    }

    @Override
    public void showUpdateTaskMenu() {
        System.out.println("------------------------------------------------");
        System.out.println("                Delete task menu                ");
        System.out.println("------------------------------------------------");
        System.out.println();
        System.out.println("Please provide the number of the task you would like to update:");
        Long id = scanner.nextLong(); scanner.nextLine();

        System.out.println("Which task information would you like to update?");
        System.out.println("1 - Title, 2 - Description, 3 - Date, 4 - Time");
        int option = scanner.nextInt(); scanner.nextLine();

        switch (option) {
            case 1:
                //showUpdateTitleMenu();
                break;
            case 2:
                //showUpdateDescriptionMenu();
                break;
            case 3:
                //showUpdateDeadlineMenu();
                break;
            case 4:
                //showUpdateDeadlineMenu();
                break;
            default:
                System.out.println("There is no such option, please try again.");
        }
    }

    @Override
    public void showDeleteTaskMenu() {
        System.out.println("------------------------------------------------");
        System.out.println("                Delete task menu                ");
        System.out.println("------------------------------------------------");
        System.out.println();
        System.out.println("Please provide the id of the task you would like to delete:");
        Integer id = scanner.nextInt(); scanner.nextLine();

        service.deleteTask(id);
    }

    @Override
    public void printTasks() {
        List<Task> allTasks = service.getAllTasks();

        System.out.println("Showing all tasks...");
        for (Task task : allTasks) {
            System.out.println(task.toString());
        }
    }

    public void showListTasksByTypeMenu() {

        System.out.println("These are the available task types:");
        System.out.println("1 - Regular, 2 - Personal, 3 - Study, 4 - Work");
        System.out.println();
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

    }

    public void showListTasksByDeadlineMenu() {
        // today, tomorrow, next 7 days, next 30 days
    }
    public void showUpdateTitleMenu(BaseTask task) {
        System.out.println("Please inform the following:");
        System.out.println("New task title: ");
        String title = scanner.nextLine();

        //service.updateTask(task,new BaseTask(title,task.getDescription(),task.getDate(), task.getTime()));
    }
    public void showUpdateDescriptionMenu(BaseTask task) {
        System.out.println("Please inform the following:");
        System.out.println("New task description: ");
        String description = scanner.nextLine();

        //service.updateTask(task,new BaseTask(task.getTitle(),description,task.getDate(), task.getTime()));
    }
    public void showUpdateDeadlineMenu(BaseTask task) {
        System.out.println("Please inform the following:");
        System.out.println("New task date (DD/MM/YYYY): ");
        String date = scanner.nextLine();

        //service.updateTask(task,new BaseTask(task.getTitle(),task.getDescription(),task.getDate(), task.getTime()));
    }

    public void printTasksByType(Class taskType, String taskTypeString) {
        List<Task> filteredTasks = service.filterTasksByType(taskType);

        System.out.println("Showing " + taskTypeString + " Tasks...");
        for (Task task: filteredTasks) {
            System.out.println(task.toString());
        }
    }

    @Override
    public boolean isValidDate(String dateString) {
        try {
            LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    @Override
    public boolean isValidTime(String timeString) {
        try {
            LocalTime.parse(timeString, DateTimeFormatter.ofPattern("HH:mm"));
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}

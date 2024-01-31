package br.com.ada.adatask.controller;

import br.com.ada.adatask.domain.*;
import br.com.ada.adatask.service.TaskService;

import java.util.List;
import java.util.Scanner;

public class TaskMainController {

    protected final TaskService<Task> service;
    private final TaskController<BaseTask> baseController;
    private final TaskController<PersonalTask> personalController;
    private final TaskController<StudyTask> studyController;
    private final TaskController<WorkTask> workController;
    private final Scanner scanner;

    public TaskMainController(TaskService<Task> service,
                              TaskController<BaseTask> baseController,
                              TaskController<PersonalTask> personalController,
                              TaskController<StudyTask> studyController,
                              TaskController<WorkTask> workController,
                              Scanner scanner) {
        this.service = service;
        this.baseController = baseController;
        this.personalController = personalController;
        this.studyController = studyController;
        this.workController = workController;
        this.scanner = scanner;
    }

    public void listTasks() {
        List<Task> allTasks = service.getAllTasks();

        if (allTasks.isEmpty()) {
            System.out.println("The task list is empty.\n");
            return;
        }

        System.out.println("                           Task list                           ");
        System.out.println("---------------------------------------------------------------");
        for (Task task : allTasks) {
            System.out.println(task.toString());
        }
    }

    public void listTasksByType() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("                           List tasks                          ");
        System.out.println("---------------------------------------------------------------");
        System.out.println();
        System.out.println("These are the available task types:");
        System.out.println("1 - Regular, 2 - Personal, 3 - Study, 4 - Work\n");
        System.out.print("Task type: ");

        int type = scanner.nextInt(); scanner.nextLine();

        System.out.println();

        switch (type) {
            case 1:
                baseController.listTasks();
                break;
            case 2:
                personalController.listTasks();
                break;
            case 3:
                studyController.listTasks();
                break;
            case 4:
                workController.listTasks();
                break;
            default:
                System.out.println("Invalid type.");
                break;
        }
    }

    public void listTasksByDeadline() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("                           List tasks                          ");
        System.out.println("---------------------------------------------------------------");
        System.out.println();

        System.out.println("Today");
        System.out.println("-----");
        List<Task> todayTasks = service.getTasksByDeadline(0);
        for (Task task : todayTasks) {
            System.out.println(task.toString());
        }

        System.out.println("Tomorrow");
        System.out.println("--------");
        List<Task> tomorrowTasks = service.getTasksByDeadline(1);
        for (Task task : tomorrowTasks) {
            System.out.println(task.toString());
        }

        System.out.println("Next week");
        System.out.println("---------");
        List<Task> nextWeekTasks = service.getTasksByDeadline(7);
        for (Task task : nextWeekTasks) {
            System.out.println(task.toString());
        }

        System.out.println("Next month");
        System.out.println("----------");
        List<Task> nextMonthTasks = service.getTasksByDeadline(30);
        for (Task task : nextMonthTasks) {
            System.out.println(task.toString());
        }
    }

    public void createTask() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("                          Create task                          ");
        System.out.println("---------------------------------------------------------------");
        System.out.println();
        System.out.println("To create a new task, please inform the following:");

        boolean isValidType = true;
        do {
            System.out.println("These are the available task types:");
            System.out.println("1 - Regular, 2 - Personal, 3 - Study, 4 - Work\n");
            System.out.println("Task type: ");
            int type = scanner.nextInt();
            scanner.nextLine();

            switch (type) {
                case 1:
                    baseController.createTask();
                    break;
                case 2:
                    personalController.createTask();
                    break;
                case 3:
                    studyController.createTask();
                    break;
                case 4:
                    workController.createTask();
                    break;
                default:
                    System.out.println("Invalid task type, please try again.");
                    isValidType = false;
                    break;
            }
        } while (!isValidType);
    }

    public void updateTask() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("                          Update task                          ");
        System.out.println("---------------------------------------------------------------");
        System.out.println();
        System.out.print("Please inform the task id: ");
        int id = scanner.nextInt(); scanner.nextLine();

        Task task = service.getTaskById(id);
        String taskType = task.getClass().getSimpleName();

        switch (taskType) {
            case "BaseTask":
                baseController.updateTask(id);
                break;
            case "PersonalTask":
                personalController.updateTask(id);
                break;
            case "StudyTask":
                studyController.updateTask(id);
                break;
            case "WorkTask":
                workController.updateTask(id);
                break;
            default:
                System.out.println("Invalid task type.");
                break;
        }
    }

    public void deleteTask() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("                          Remove task                          ");
        System.out.println("---------------------------------------------------------------");
        System.out.println();
        baseController.deleteTask();
    }
}
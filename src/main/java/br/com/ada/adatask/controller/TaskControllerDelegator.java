package br.com.ada.adatask.controller;

import br.com.ada.adatask.domain.*;
import br.com.ada.adatask.service.TaskService;

import java.util.List;
import java.util.Scanner;

public class TaskControllerDelegator {

    protected final TaskService<Task> service;
    private final TaskController<BaseTask> baseController;
    private final TaskController<PersonalTask> personalController;
    private final TaskController<StudyTask> studyController;
    private final TaskController<WorkTask> workController;
    private final Scanner scanner;

    public TaskControllerDelegator(TaskService<Task> service,
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
            System.out.println("The task list is empty.");
            return;
        }

        System.out.println("Showing all tasks...");
        for (Task task : allTasks) {
            System.out.println(task.toString());
        }
    }

    public void listTasksByType() {

        System.out.println("These are the available task types:");
        System.out.println("1 - Regular, 2 - Personal, 3 - Study, 4 - Work");
        System.out.println();
        System.out.println("Please inform the desired type:");

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

    public void createTask() {

        System.out.println("------------------------------------------------");
        System.out.println("                 Create task menu               ");
        System.out.println("------------------------------------------------");
        System.out.println();
        System.out.println("To create a new task, please inform the following:");

        boolean isValidType = true;
        do {
            System.out.println("Task type: ");
            System.out.println("These are the available task types:");
            System.out.println("1 - Regular, 2 - Personal, 3 - Study, 4 - Work");
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

        System.out.println("Please inform the task id: ");
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
        baseController.deleteTask();
    }

}

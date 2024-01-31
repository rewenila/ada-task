package br.com.ada.adatask;

import br.com.ada.adatask.controller.*;
import br.com.ada.adatask.domain.*;
import br.com.ada.adatask.repository.Repository;
import br.com.ada.adatask.repository.TaskRepository;
import br.com.ada.adatask.service.TaskService;
import br.com.ada.adatask.service.TaskServiceImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {

        Scanner scanner = new Scanner(System.in);

        Repository<Task> repository = new TaskRepository<>();
        TaskService<Task> service = new TaskServiceImpl<>(repository);

        TaskController<BaseTask> baseController = new BaseTaskController(service);
        TaskController<PersonalTask> personalController = new PersonalTaskController(service);
        TaskController<StudyTask> studyController = new StudyTaskController(service);
        TaskController<WorkTask> workController = new WorkTaskController(service);

        TaskControllerDelegator delegator = new TaskControllerDelegator(service, baseController,
                personalController, studyController, workController, scanner);

        System.out.println("""
                #############################################
                                   ADA TASK                 \s
                #############################################
                """);

        populate(service);
        run(delegator);
    }

    static void run(TaskControllerDelegator delegator) {
        Scanner scanner = new Scanner(System.in);

        int option;
        do {
            System.out.println();
            System.out.println("#################################################");
            System.out.println("                    Main menu                    ");
            System.out.println("#################################################");
            System.out.println();
            System.out.println("1: List all tasks");
            System.out.println("2: List tasks by type");
            System.out.println("3: Create new task");
            System.out.println("4: Update existing task");
            System.out.println("5: Remove task");
            System.out.println("6: Exit");
            System.out.println();
            System.out.println("Please inform your option:");

            option = scanner.nextInt(); scanner.nextLine();

            System.out.println();

            switch (option) {
                case 1:
                    delegator.listTasks();
                    break;
                case 2:
                    delegator.listTasksByType();
                    break;
                case 3:
                    delegator.createTask();
                    break;
                case 4:
                    delegator.updateTask();
                    break;
                case 5:
                    delegator.deleteTask();
                    break;
                case 6:
                    System.out.println("Exiting from Ada Task. See you soon!");
                    break;
                default:
                    System.out.println("There is no such option, please try again.");
                    break;
            }

        } while (option != 5);

    }

    public static void populate(TaskService<Task> service) {
        Task baseTask = new BaseTask(
                "Lunch",
                "Eat lunch",
                LocalDate.parse("20/02/2024", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                LocalTime.parse("20:55", DateTimeFormatter.ofPattern("HH:mm")));
        service.createTask(baseTask);

        Task personalTask = new PersonalTask("Laundry",
                "Do the weekly laundry",
                LocalDate.parse("20/02/2024", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                LocalTime.parse("20:55", DateTimeFormatter.ofPattern("HH:mm")),
            "Laundry");
        service.createTask(personalTask);

        BaseTask workTask = new WorkTask("Send email to my boss",
                "Send email asking about project deadline",
                LocalDate.parse("20/02/2024", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                LocalTime.parse("20:55", DateTimeFormatter.ofPattern("HH:mm")),
                "Project X");
        service.createTask(workTask);

        BaseTask studyTask = new StudyTask("Exercise list",
                "Finish exercise list about generics",
                LocalDate.parse("20/02/2024", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                LocalTime.parse("20:55", DateTimeFormatter.ofPattern("HH:mm")),
                "Object-Oriented Programming");
        service.createTask(studyTask);
    }

}
# AdaTask: Task Management Application

## Overview
AdaTask is a console application designed for task management. It enables users to create, 
edit, delete, and view tasks. Data persistence 
is simulated using in-memory lists.

## Project Structure

### Domain Layer
- `Task`: Interface that defines common methods for all task classes.
- `BaseTask`: Class that defines common attributes for all tasks. 
- `PersonalTask`: Extends `BaseTask` and defines specific attributes for personal tasks, like category.
- `StudyTask`: Extends `BaseTask` and defines specific attributes for study tasks, like subject.
- `WorkTask`: Extends `BaseTask` and defines specific attributes for work tasks, like project.

### Repository Layer

Responsible for the simulated persistence of data in lists.
Provides methods to add, remove, update, and search for tasks.

- `Repository`: Generic interface that defines methods to add, remove, update, and search for data.
- `TasksRepository`: Implementation of `Repository` that implements methods to add, remove, update, and search for tasks stored in a list.

### Service Layer

Contains application logic, such as task manipulation operations.
Interacts with the Repository layer to perform data operations.

- `TaskService`: Interface that define methods for task manipulation operations.
- `TaskServiceImpl`: Implementation of `TaskService`. Provides methods to list all tasks, list tasks by type, list tasks by deadline, create tasks, update tasks, and remove tasks, as well as methods to validate task rules: two tasks can not be scheduled for a past date and two tasks can not be scheduled for the same time.

### Controller Layer

Manages user interaction with the system via the console.
Processes user commands and uses the service layer to execute operations.

- `TaskMainController`: Task controller class that delegates responsabilities depending on task type.
- `TaskController`: Interface that define common methods for specific task controller classes.
- `BaseTaskController`: Task controller for base tasks.
- `PersonalTaskController`: Task controller for personal tasks.
- `StudyTaskController`: Task controller for study tasks.
- `WorkTaskController`: Task controller for work tasks.

### Main
- `Main`: Shows welcome message and main menu.

## Key Features
- **Task Creation:** Add new tasks with details such as title, description, date, and time, as well as specific attributes of each task type.

- **Task Editing:** Update details of existing tasks such as title, description, date, and time, as well as specific attributes of each task type.

- **Task Removal:** Delete existing tasks.

- **Task Viewing:** List all tasks, list tasks by type and list tasks by deadline.

## Getting Started
- Make sure you have Java installed in your machine.
- Clone this repository:
  ```
  git clone https://github.com/rewenila/ada-task.git
  ```

- Run the application.

## Usage

Run the application and follow the instructions. The main menu provides the following options: 

- **List tasks:** Shows a list of all registered tasks.
- **List tasks by type:** Shows a list of all the registered tasks of the chosen type. Inform the type number to choose a task type.
- **List tasks by deadline:** Shows a list of all registered tasks grouped by deadline. The deadline groups are: today, tomorrow, next week and next month.
- **Create task:** Inform the type of task you would like to create. Inform name, description, date, and time of the task, as well of speficic type information: category for personal tasks, subject for study tasks, and project for work tasks. Pay attention to date and time formats.
- **Update task:** Inform the id of the task you would like to update. Then inform the same information as in the create task option.
- **Delete task:** Inform the id of the task you would like to delete. 

## License
This project is licensed under the [MIT License](https://choosealicense.com/licenses/mit/).



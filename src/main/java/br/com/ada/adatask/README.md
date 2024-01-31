# AdaTask: Task Management Application

## Overview
AdaTask is a console application designed for task management. It enables users to create, 
edit, delete, and view tasks. Data persistence 
is simulated using in-memory lists.

## Project Structure

### Domain Layer:
- `BaseTask`: class that define common attributes for all task. 
- `PersonalTask`: extends `BaseTask` and define specific attributes for personal tasks, like category.
- `StudyTask`: extends `BaseTask` and define specific attributes for study tasks, like subject.
- `WorkTask`: extends `BaseTask` and define specific attributes for work tasks, like project.

### Repository Layer:

Responsible for the simulated persistence of data in lists.
Provides methods to add, remove, update, and search for tasks.

- `Repository`: Generic interface that defined methods to add, remove, update, and search for data.
- `TasksRepository`: Implementation of `Repository` that implements methods to add, remove, update, and search for tasks stored in a list.

### Service Layer:

Contains application logic, such as task manipulation operations.
Interacts with the Repository layer to perform data operations.

- `TaskService`:
- `TaskServiceImpl`:

### Controller Layer:

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
- **Task Creation:** Add new tasks with details such as title, description, date, time, etc.

- **Task Editing:** Update details of existing tasks such as title, description, date, and time, as well as specific attributes of each task type, by its `id`.

- **Task Removal:** Delete existing tasks by its `id`.

- **Task Viewing:** List all tasks, list tasks by type and list tasks by deadline.



## Getting Started

## Usage

## Contributing

## License




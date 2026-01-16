package ui;

import service.TaskService;
import model.Task;
import java.util.Scanner;

public class Menu {
    private TaskService taskService;
    private Scanner scanner;

    public Menu() {
        taskService = new TaskService();
        scanner = new Scanner(System.in);
    }

    public void start() {
        int option;
        do {
            System.out.println("==== TASK ORGANIZER ====");
            System.out.println("1. Add task");
            System.out.println("2. List tasks");
            System.out.println("3. Mark task as completed");
            System.out.println("4. Remove task");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // limpa o buffer

            switch(option) {
                case 1: addTask(); break;
                case 2: listTasks(); break;
                case 3: markCompleted(); break;
                case 4: removeTask(); break;
                case 0: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid option!"); break;
            }
        } while(option != 0);
    }

    private void addTask() {
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Priority (1-High, 2-Medium, 3-Low): ");
        int priority = scanner.nextInt();
        scanner.nextLine();

        Task task = new Task(title, priority);
        taskService.addTask(task);
    }

    private void listTasks() {
        taskService.listTasks();
    }

    private void markCompleted() {
        System.out.print("Enter task ID to complete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        taskService.markTaskAsCompleted(id);
    }

    private void removeTask() {
        System.out.print("Enter task ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        taskService.removeTask(id);
    }
}

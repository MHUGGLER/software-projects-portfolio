package service;

import model.Task;
import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private List<Task> tasks;

    public TaskService() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    public void listTasks() {
        if(tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for(Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    public void markTaskAsCompleted(int id) {
        for(Task task : tasks) {
            if(task.getId() == id) {
                task.markAsCompleted();
                System.out.println("Task marked as completed!");
                return;
            }
        }
        System.out.println("Task with ID " + id + " not found.");
    }

    public void removeTask(int id) {
        for(Task task : tasks) {
            if(task.getId() == id) {
                tasks.remove(task);
                System.out.println("Task removed!");
                return;
            }
        }
        System.out.println("Task with ID " + id + " not found.");
    }
}

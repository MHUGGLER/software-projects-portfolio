package model;

public class Task {
    private static int counter = 1; // para gerar IDs automáticos
    private int id;
    private String title;
    private int priority; // 1 = alta, 2 = média, 3 = baixa
    private boolean completed;

    public Task(String title, int priority) {
        this.id = counter++;
        this.title = title;
        this.priority = priority;
        this.completed = false;
    }

    public int getId() {
        return id;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markAsCompleted() {
        completed = true;
    }

    @Override
    public String toString() {
        return id + " | " + title +
               " | Priority: " + priority +
               " | " + (completed ? "DONE" : "PENDING");
    }
}

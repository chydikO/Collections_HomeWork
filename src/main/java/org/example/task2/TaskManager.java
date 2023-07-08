package org.example.task2;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private final List<String> tasks = new ArrayList<>();

    public boolean completeTask(int indexToMarkDone) {
        if (indexToMarkDone >= 0 && indexToMarkDone < tasks.size()) {
            String task = tasks.get(indexToMarkDone);
            String markedTask = "[X] " + task + " [Completed]";
            tasks.set(indexToMarkDone, markedTask);
            return true;
        } else {
            return false;
        }
    }

    public List<String> getAllTasks() {
        return tasks;
    }

    public void addTask(String newTask) {
        tasks.add(newTask);
        System.out.println("Завдання додано.");
    }

    public boolean removeTask(int taskIndex) {
        return taskIndex < tasks.size() && tasks.remove(taskIndex) != null;
    }

    public void printAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Список завдань порожній.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(i + ". " + tasks.get(i));
            }
        }
    }
}

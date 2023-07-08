package org.example.task2;

import java.util.Scanner;

public class AppToDoList {
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        while (true) {
            System.out.println("\nВиберіть опцію:");
            System.out.println("1. Додати завдання");
            System.out.println("2. Видалити завдання");
            System.out.println("3. Відзначити завдання як виконане");
            System.out.println("4. Переглянути список завдань");
            System.out.println("5. Вийти");

            int choice = Integer.valueOf(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Введіть завдання: ");
                    String newTask = scanner.nextLine();
                    taskManager.addTask(newTask);
                }
                case 2 -> {
                    System.out.print("Введіть індекс завдання, яке потрібно видалити: ");
                    int taskIndexToRemove = Integer.valueOf(scanner.nextLine());
                    if (taskManager.removeTask(taskIndexToRemove)) {
                        System.out.println("Завдання видалено.");
                    } else {
                        System.out.println("завдання не єснуе.");
                    }
                }
                case 3 -> {
                    System.out.print("Введіть індекс завдання, яке потрібно відзначити як виконане: ");
                    int indexToMarkDone = Integer.valueOf(scanner.nextLine());
                    if (taskManager.completeTask(indexToMarkDone)) {
                        System.out.println("Завдання відзначено як виконане.");
                    } else {
                        System.out.println("Неправильний індекс завдання.");
                    }
                }
                case 4 -> {
                    System.out.println("Список завдань:");
                    taskManager.printAllTasks();
                }
                case 5 -> {
                    System.out.println("До побачення!");
                    return;
                }
                default -> System.out.println("Неправильний вибір опції. Спробуйте ще раз.");
            }
        }
    }
}

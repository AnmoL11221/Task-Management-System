package taskmanager;

import java.util.ArrayList;
import java.util.Scanner;

// Interface definition
public interface TaskManager {
    void addTask(String taskName);
    void listTasks();
    void markTaskComplete(int taskIndex);
    void removeTask(int taskIndex);
}

// Main class implementing TaskManager interface
package taskmanager;

public class Main implements TaskManager {
    private static final ArrayList<String> tasks = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Task Management System");
        Main mainApp = new Main();
        mainApp.start();
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            displayMenu();
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline character
            switch (choice) {
                case 1:
                    System.out.print("Enter task name: ");
                    String taskName = sc.nextLine();
                    addTask(taskName);
                    break;
                case 2:
                    listTasks();
                    break;
                case 3:
                    System.out.print("Enter the task number to mark as complete: ");
                    int taskIndex = sc.nextInt();
                    markTaskComplete(taskIndex);
                    break;
                case 4:
                    System.out.print("Enter the task number to remove: ");
                    int removeTaskIndex = sc.nextInt();
                    removeTask(removeTaskIndex);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 5);
        sc.close();
    }

    private void displayMenu() {
        System.out.println("\nSelect an option:");
        System.out.println("1. Add Task");
        System.out.println("2. List Tasks");
        System.out.println("3. Mark Task as Complete");
        System.out.println("4. Remove Task");
        System.out.println("5. Exit");
    }

    @Override
    public void addTask(String taskName) {
        tasks.add(taskName);
        System.out.println("Task added: " + taskName);
    }

    @Override
    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    @Override
    public void markTaskComplete(int taskIndex) {
        if (taskIndex >= 1 && taskIndex <= tasks.size()) {
            System.out.println("Task marked as complete: " + tasks.get(taskIndex - 1));
            tasks.remove(taskIndex - 1);
        } else {
            System.out.println("Invalid task number.");
        }
    }

    @Override
    public void removeTask(int taskIndex) {
        if (taskIndex >= 1 && taskIndex <= tasks.size()) {
            System.out.println("Removed task: " + tasks.get(taskIndex - 1));
            tasks.remove(taskIndex - 1);
        } else {
            System.out.println("Invalid task number.");
        }
    }
}

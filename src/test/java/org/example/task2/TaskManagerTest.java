package org.example.task2;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {
    private TaskManager taskManager;

    @Before
    public void setUp() {
        taskManager = new TaskManager();
    }

    @Test
    public void testAddTask() {
        String taskName = "Task 1";
        taskManager.addTask(taskName);

        List<String> tasks = taskManager.getAllTasks();
        assertEquals(1, tasks.size());
        assertEquals(taskName, tasks.get(0));
    }

    @Test
    public void testRemoveTask() {
        String taskName1 = "Task 1";
        taskManager.addTask(taskName1);

        String taskName2 = null;
        taskManager.addTask(taskName2);

        boolean removed = taskManager.removeTask(0);
        assertTrue(removed);

        removed = taskManager.removeTask(0);
        assertFalse(removed);

        removed = taskManager.removeTask(2);
        assertFalse(removed);

        List<String> tasks = taskManager.getAllTasks();
        assertEquals(0, tasks.size());
    }

    @Test
    public void testCompleteTask() {
        String taskName = "Task 1";
        taskManager.addTask(taskName);

        boolean completed = taskManager.completeTask(0);
        assertTrue(completed);

        List<String> tasks = taskManager.getAllTasks();
        assertEquals(1, tasks.size());
        assertTrue(tasks.get(0).startsWith("[X]"));
        assertTrue(tasks.get(0).endsWith("[Completed]"));
    }

    @Test
    public void testGetAllTasks() {
        taskManager.addTask("Task 1");
        taskManager.addTask("Task 2");
        taskManager.addTask("Task 3");

        List<String> tasks = taskManager.getAllTasks();
        assertEquals(3, tasks.size());
    }
}
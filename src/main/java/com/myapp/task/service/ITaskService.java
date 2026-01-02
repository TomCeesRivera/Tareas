package com.myapp.task.service;

import com.myapp.task.model.Task;

import java.util.List;

public interface ITaskService {

    List<Task> getTasks();

    List<Task> getTasksDone(String done);

    Task findTask(Long id);

    Task createTask(Task task);

    Task updateTask(Long id, Task task);

    void deleteTask(Long id);
}

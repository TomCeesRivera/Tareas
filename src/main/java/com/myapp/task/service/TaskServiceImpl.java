package com.myapp.task.service;

import com.myapp.task.exception.TaskNotFoundException;
import com.myapp.task.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myapp.task.repository.TaskRepository;

import java.util.List;

@Service
public class TaskServiceImpl implements ITaskService{

    @Autowired
    TaskRepository taskRepository;

    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> getTasksDone(String done) {
        if(!done.equals("true") && !done.equals("false")){
            throw new IllegalArgumentException("El valor de 'done' debe ser true o false");
        }
        boolean doneBoolean = Boolean.parseBoolean(done);

        return taskRepository.findByDone(doneBoolean);
    }

    @Override
    public Task findTask(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("No se encuentra la tarea solicitada"));
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long id, Task task) {
        Task updateTask = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("No se encuentra la tarea solicitada"));
        updateTask.setTitle(task.getTitle());
        updateTask.setDescription(task.getDescription());
        updateTask.setDone(task.isDone());
        taskRepository.save(updateTask);

        return updateTask;
    }

    @Override
    public void deleteTask(Long id) {
        if(!taskRepository.existsById(id)){
            throw new TaskNotFoundException("No se encuentra la tarea a eliminar");
        }

        taskRepository.deleteById(id);
    }
}

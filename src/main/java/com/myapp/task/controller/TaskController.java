package com.myapp.task.controller;

import com.myapp.task.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.myapp.task.service.ITaskService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    ITaskService taskService;

    @GetMapping
    public List<Task> getTasks(){
        return taskService.getTasks();
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Task>> getTasksDone(@RequestParam String done){
        return ResponseEntity.ok(taskService.getTasksDone(done));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findTask(@PathVariable Long id){
        return ResponseEntity.ok(taskService.findTask(id));
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        Task taskCreated = taskService.createTask(task);

        return ResponseEntity
                .created(URI.create("/tasks/" + taskCreated.getId()))
                .body(taskCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task){
        return ResponseEntity.ok(taskService.updateTask(id, task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);

        return ResponseEntity.noContent().build();
    }
}

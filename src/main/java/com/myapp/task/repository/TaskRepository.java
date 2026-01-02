package com.myapp.task.repository;

import com.myapp.task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByDone(boolean done);
}

package com.example.task_manager_backend.repository;

import com.example.task_manager_backend.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}


package com.example.task_manager_backend.controller;

import com.example.task_manager_backend.model.Task;
import com.example.task_manager_backend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tasks")
public class TaskController {
  @Autowired
  private TaskRepository taskRepository;

  @GetMapping
  public List<Task> getAllTasks() {
    return taskRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
    return taskRepository.findById(id)
        .map(task -> ResponseEntity.ok().body(task))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping
  public Task createTask(@RequestBody Task task) {
    return taskRepository.save(task);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
    return taskRepository.findById(id)
        .map(task -> {
          task.setTitle(taskDetails.getTitle());
          task.setDescription(taskDetails.getDescription());
          task.setCompleted(taskDetails.isCompleted());
          return ResponseEntity.ok().body(taskRepository.save(task));
        })
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteTask(@PathVariable Long id) {
    return taskRepository.findById(id)
        .map(task -> {
          taskRepository.delete(task);
          return ResponseEntity.ok().build();
        })
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

}

package com.example.task_manager_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Task{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;
  private String description;
  private boolean completed;
  
  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setTitle(String title) {
    this.title = title;
  }
  
  public String getTitle() {
    return title;
  }
  
  public void setDescription(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
  
  public void setCompleted(boolean completed) {
    this.completed = completed;
  }

  public boolean isCompleted() {
    return completed;
  }

}

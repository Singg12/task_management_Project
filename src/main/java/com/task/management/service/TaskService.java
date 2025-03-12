package com.task.management.service;

import java.util.List;

import com.task.management.model.Task;

public interface TaskService {
    Task createTask(Task task);
    List<Task> getAllTask();
    Task getTaskById(Long id);
    Task updateTask(Long id, Task taskUpdate);
    Task deleteTaskById(Long id);
    
} 
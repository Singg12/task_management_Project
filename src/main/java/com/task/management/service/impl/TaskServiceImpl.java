package com.task.management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;


import com.task.management.model.Task;
import com.task.management.repository.TaskRepository;
import com.task.management.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public Task createTask(Task task) {
        SimpleMailMessage message =  new SimpleMailMessage();
        message.setTo(task.getAssignTo());
        message.setSubject(task.getTaskName());
        message.setText(task.getDescription());
        mailSender.send(message);
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTask() {
       return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(()-> new RuntimeException("ID not found"));
    }

    @Override
    public Task updateTask(Long id, Task taskUpdate) {
        Task task = getTaskById(id);
        task.setTaskName(taskUpdate.getTaskName());
        task.setStatus(taskUpdate.getStatus());
        return taskRepository.save(task);

        }

    @Override
    public Task deleteTaskById(Long id) {
        Task task = getTaskById(id);
        taskRepository.delete(task);
        return task;
    }

    
   
   
}

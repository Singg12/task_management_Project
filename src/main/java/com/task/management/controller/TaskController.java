package com.task.management.controller;

import org.springframework.web.bind.annotation.RestController;

import com.task.management.model.Task;
import com.task.management.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
@RequestMapping("/task")
public class TaskController {
    
    @Autowired
    private TaskService taskService;

    @PreAuthorize("hasAuthority('task:write')")
    @PostMapping("/create")
    public ResponseEntity<?> createTask(@RequestBody Task task) {
        return new ResponseEntity<>(taskService.createTask(task), HttpStatus.CREATED);
    }
    @PreAuthorize("hasAuthority('task:read')")
    @GetMapping()
    public ResponseEntity<?> getAllTask() {
        return new ResponseEntity<>(taskService.getAllTask(), HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('task:read')")
    @GetMapping("{id}")
    public ResponseEntity<?> getTaskById(@PathVariable("id") Long taskId) {
        return new ResponseEntity<>(taskService.getTaskById(taskId), HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('task:update')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTaskById( @PathVariable("id") Long taskId,@RequestBody Task task) {
        return new ResponseEntity<>(taskService.updateTask(taskId, task),HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('task:delete')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTaskById(@PathVariable("id") Long taskId) {
       return new ResponseEntity<>(taskService.deleteTaskById(taskId),HttpStatus.OK);
    }
    
    
    
    
    
}

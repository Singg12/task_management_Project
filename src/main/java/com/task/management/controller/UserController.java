package com.task.management.controller;

import org.springframework.web.bind.annotation.RestController;

import com.task.management.model.Users;
import com.task.management.service.UserService;

import jakarta.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RolesAllowed("ROLE_ADMIN")
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @PreAuthorize("hasAuthority('user:write')")
    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody Users user) {
        return new ResponseEntity<>(userService.createUser(user),HttpStatus.CREATED);
    }
    @PreAuthorize("hasAuthority('user:read')")
    @GetMapping()
    public ResponseEntity<?> getAllUser() {
        return new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('user:read')")
    @GetMapping("{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long userId) {
        return new ResponseEntity<>(userService.getUserById(userId),HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('user:update')")
    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateUserById(@PathVariable("id") Long id , @RequestBody Users updateUser) {
        return new ResponseEntity<>(userService.updateUser(id, updateUser) , HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('user:delete')")
    @PostMapping("delete/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") Long userId) {
      
        return new ResponseEntity<>(userService.deleteUser(userId),HttpStatus.OK);
    }
    
    
    
    
}

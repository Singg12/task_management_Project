package com.task.management.service;

import java.util.List;
import java.util.Optional;

import com.task.management.config.security.AuthUser;
import com.task.management.model.Users;

public interface UserService {
    Users createUser(Users user);
    List<Users> getAllUser();
    Users getUserById(Long id);
    Users updateUser(Long id,Users updateUser);
    Users deleteUser(Long id);
    Optional<AuthUser> findUserByUsername(String username);
}

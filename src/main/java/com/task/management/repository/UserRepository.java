package com.task.management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.management.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users,Long>{
    Optional<Users> findUserByUsername(String email);
}

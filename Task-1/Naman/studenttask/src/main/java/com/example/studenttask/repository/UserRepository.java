package com.example.studenttask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.studenttask.entity.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
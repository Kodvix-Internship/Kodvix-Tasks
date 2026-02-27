package com.example.studenttask.repository;

import com.example.studenttask.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TaskRepository extends JpaRepository<Task, Long> {
}
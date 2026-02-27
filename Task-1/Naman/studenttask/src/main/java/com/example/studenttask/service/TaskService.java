package com.example.studenttask.service;

import com.example.studenttask.dto.TaskRequest;
import com.example.studenttask.entity.Task;

import java.util.List;

public interface TaskService {

    Task createTask(TaskRequest request);

    List<Task> getAllTasks();

    Task getTaskById(Long id);

    Task updateTask(Long id, TaskRequest request);

    void deleteTask(Long id);
}

package com.example.studenttask.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskRequest {

    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    @NotBlank(message = "Priority is required")
    private String priority;   // HIGH, MEDIUM, LOW

    @NotBlank(message = "Status is required")
    private String status;     // PENDING, IN_PROGRESS, COMPLETED

    @NotNull(message = "Due date is required")
    private LocalDate dueDate;
}

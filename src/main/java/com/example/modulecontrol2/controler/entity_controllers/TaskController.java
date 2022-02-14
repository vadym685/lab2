package com.example.modulecontrol2.controler.entity_controllers;

import com.example.modulecontrol2.model.Task;
import com.example.modulecontrol2.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TaskController {
    @Autowired
    private TaskRepo taskRepository;

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}

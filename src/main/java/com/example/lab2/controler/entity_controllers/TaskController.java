package com.example.lab2.controler.entity_controllers;

import com.example.lab2.model.Task;
import com.example.lab2.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


import javax.servlet.http.HttpServletRequest;
import java.rmi.ServerException;
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

    @PostMapping("/task")
    public ResponseEntity<Task> addTask(HttpServletRequest request,
                                        UriComponentsBuilder uriComponentsBuilder) throws ServerException {
        Task task = taskRepository.save(new Task());


        if (task == null) {
            throw new ServerException("Cannot construct dao.");
        } else {
            return new ResponseEntity<>(task, HttpStatus.CREATED);
        }
    }
}

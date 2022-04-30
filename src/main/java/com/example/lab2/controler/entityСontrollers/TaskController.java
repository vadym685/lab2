package com.example.lab2.controler.entityСontrollers;

import com.example.lab2.model.Task;
import com.example.lab2.repository.TaskRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class TaskController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskRepo taskRepository;

    @GetMapping("/tasks")
    public List<Task> getAllTasks(HttpServletRequest request) {
        return taskRepository.findAll();
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable(value = "id") Long taskId, HttpServletRequest request)
            throws ResourceNotFoundException {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found for this id :: " + taskId));
        return ResponseEntity.ok().body(task);
    }

    @PostMapping("/task")
    public ResponseEntity<Task> addTask(@Validated @RequestBody Task requestBody, HttpServletRequest request) {

        try {
            Task task = taskRepository.save(requestBody);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
        }
    }

    @PutMapping("/task/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable(value = "id") Long taskId,
                                           @Validated @RequestBody Task taskNew, HttpServletRequest request) throws ResourceNotFoundException {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found for this id :: " + taskId));

        task.setDate(taskNew.getDate());
        task.setPersons(taskNew.getPersons());
        task.setPoint(taskNew.getPointObj());
        task.setPositions(taskNew.getPositions());
        final Task updatedTask = taskRepository.save(task);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/task/{id}")
    public Map<String, Boolean> deleteTask(@PathVariable(value = "id") Long taskId, HttpServletRequest request)
            throws ResourceNotFoundException {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found for this id :: " + taskId));

        taskRepository.delete(task);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

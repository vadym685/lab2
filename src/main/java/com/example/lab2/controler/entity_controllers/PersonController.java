package com.example.lab2.controler.entity_controllers;

import com.example.lab2.model.Consumables;
import com.example.lab2.model.Person;
import com.example.lab2.repository.ConsumablesRepo;
import com.example.lab2.repository.PersonRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PersonController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonRepo personsRepository;

    @GetMapping("/persons")
    public List<Person> getAllTasks() {
        return personsRepository.findAll();
    }

    @PostMapping("/person")
    public ResponseEntity<Person> addTask(@Validated @RequestBody Person request) {

        try {
            Person person = personsRepository.save(request);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
        }
    }

}

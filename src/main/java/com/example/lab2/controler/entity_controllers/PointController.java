package com.example.lab2.controler.entity_controllers;

import com.example.lab2.model.Point;
import com.example.lab2.repository.PointRepo;
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
public class PointController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PointController.class);

    @Autowired
    private PointRepo pointRepository;

    @GetMapping("/points")
    public List<Point> getAllPoints() {
        return pointRepository.findAll();
    }

    @PostMapping("/point")
    public ResponseEntity<Point> addTask(@Validated @RequestBody Point request) {
        try {
            Point point = pointRepository.save(request);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
        }
    }
}
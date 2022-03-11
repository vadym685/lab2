package com.example.lab2.controler.entity_controllers;

import com.example.lab2.model.Position;
import com.example.lab2.repository.PositionRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PositionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PositionController.class);

    @Autowired
    private PositionRepo positionRepository;

    @GetMapping("/position")
    public List<Position> getAllTasks() {
        return positionRepository.findAll();
    }

}

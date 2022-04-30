package com.example.lab2.controler.entityСontrollers;

import com.example.lab2.model.Position;
import com.example.lab2.repository.PositionRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class PositionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PositionController.class);

    @Autowired
    private PositionRepo positionRepository;

    @GetMapping("/positions")
    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }

    @DeleteMapping("/positions")
    public Map<String, Boolean> deleteAllPositions()
            throws ResourceNotFoundException {
        positionRepository.deleteAll();

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}

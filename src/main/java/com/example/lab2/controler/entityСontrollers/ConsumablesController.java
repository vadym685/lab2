package com.example.lab2.controler.entityСontrollers;

import com.example.lab2.model.Consumables;
import com.example.lab2.repository.ConsumablesRepo;
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
public class ConsumablesController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumablesController.class);

    @Autowired
    private ConsumablesRepo consumablesRepository;

    @GetMapping("/consumables")
    public List<Consumables> getAllConsumables() {
        return consumablesRepository.findAll();
    }

    @DeleteMapping("/consumables")
    public Map<String, Boolean> deleteConsumable()
            throws ResourceNotFoundException {

        consumablesRepository.deleteAll();
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}

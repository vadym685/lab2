package com.example.lab2.controler.entityСontrollers;

import com.example.lab2.model.Consumables;
import com.example.lab2.repository.ConsumablesRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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

    @GetMapping("/consumable/{id}")
    public ResponseEntity<Consumables> getConsumableById(@PathVariable(value = "id") Long consumablesId)
            throws ResourceNotFoundException {
        Consumables consumable = consumablesRepository.findById(consumablesId)
                .orElseThrow(() -> new ResourceNotFoundException("Consumables not found for this id :: " + consumablesId));
        return ResponseEntity.ok().body(consumable);
    }

    @PostMapping("/consumable")
    public ResponseEntity<Consumables> addConsumable(@Validated @RequestBody Consumables request) {
        try {
            Consumables consumable = consumablesRepository.save(request);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
        }
    }


    @PutMapping("/consumable/{id}")
    public ResponseEntity<Consumables> updateConsumable(@PathVariable(value = "id") Long consumablesId,
                                           @Validated @RequestBody Consumables consumablesNew) throws ResourceNotFoundException {
        Consumables consumable = consumablesRepository.findById(consumablesId)
                .orElseThrow(() -> new ResourceNotFoundException("Consumables not found for this id :: " + consumablesId));

        consumable.setComment(consumablesNew.getComment());
        consumable.setDescription(consumablesNew.getDescription());

        final Consumables updatedConsumables = consumablesRepository.save(consumable);
        return ResponseEntity.ok(updatedConsumables);
    }

    @DeleteMapping("/consumable/{id}")
    public Map<String, Boolean> deleteConsumable(@PathVariable(value = "id") Long consumablesId)
            throws ResourceNotFoundException {
        Consumables consumable = consumablesRepository.findById(consumablesId)
                .orElseThrow(() -> new ResourceNotFoundException("Consumables not found for this id :: " + consumablesId));

        consumablesRepository.delete(consumable);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}

package com.example.lab2.controler.entityСontrollers;

import com.example.lab2.model.Position;
import com.example.lab2.repository.PositionRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
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
    public List<Position> getAllPositions(HttpServletRequest request) {
        Principal user = request.getUserPrincipal();
        LOGGER.info("User with name " + user.getName() + " get all positions");

        return positionRepository.findAll();
    }

    @DeleteMapping("/positions")
    public Map<String, Boolean> deleteAllPositions(HttpServletRequest request)
            throws ResourceNotFoundException {
        Principal user = request.getUserPrincipal();
        LOGGER.info("User with name " + user.getName() + " delete all positions");

        positionRepository.deleteAll();

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}

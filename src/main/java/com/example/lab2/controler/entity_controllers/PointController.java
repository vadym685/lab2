package com.example.lab2.controler.entity_controllers;

import com.example.lab2.model.Point;
import com.example.lab2.repository.PointRepo;
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
public class PointController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PointController.class);

    @Autowired
    private PointRepo pointRepository;

    @GetMapping("/points")
    public List<Point> getAllPoints() {
        return pointRepository.findAll();
    }

    @GetMapping("/point/{id}")
    public ResponseEntity<Point> getPointById(@PathVariable(value = "id") Long pointId)
            throws ResourceNotFoundException {
        Point point = pointRepository.findById(pointId)
                .orElseThrow(() -> new ResourceNotFoundException("Point not found for this id :: " + pointId));
        return ResponseEntity.ok().body(point);
    }

    @PostMapping("/point")
    public ResponseEntity<Point> addPoint(@Validated @RequestBody Point request) {
        try {
            Point point = pointRepository.save(request);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
        }
    }

    @PutMapping("/point/{id}")
    public ResponseEntity<Point> updatePoint(@PathVariable(value = "id") Long pointId,
                                                   @Validated @RequestBody Point pointNew) throws ResourceNotFoundException {
        Point point = pointRepository.findById(pointId)
                .orElseThrow(() -> new ResourceNotFoundException("Point not found for this id :: " + pointId));

        point.setAdress(pointNew.getAdress());
        point.setComment(pointNew.getComment());
        point.setContactNumber(pointNew.getContactNumber());
        point.setName(pointNew.getName());
        point.setLongitude(pointNew.getLongitude());
        point.setLatitude(pointNew.getLatitude());
        point.setContactPerson(pointNew.getContactPerson());
        final Point updatedPoint = pointRepository.save(point);
        return ResponseEntity.ok(updatedPoint);
    }

    @DeleteMapping("/point/{id}")
    public Map<String, Boolean> deletePoint(@PathVariable(value = "id") Long pointId)
            throws ResourceNotFoundException {
        Point employee = pointRepository.findById(pointId)
                .orElseThrow(() -> new ResourceNotFoundException("Point not found for this id :: " + pointId));

        pointRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

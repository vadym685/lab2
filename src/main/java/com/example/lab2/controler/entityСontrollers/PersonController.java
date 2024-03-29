package com.example.lab2.controler.entityСontrollers;

import com.example.lab2.model.Person;
import com.example.lab2.repository.PersonRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class PersonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonRepo personsRepository;

    @GetMapping("/persons")
    public List<Person> getAllPersons(HttpServletRequest request) {
        Principal user = request.getUserPrincipal();
        LOGGER.info("User with name " + user.getName() + " get all persons");

        return personsRepository.findAll();
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable(value = "id") Long personId, HttpServletRequest request)
            throws ResourceNotFoundException {

        Principal user = request.getUserPrincipal();
        LOGGER.info("User with name " + user.getName() + " find person with id " + personId);

        Person person = personsRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + personId));
        return ResponseEntity.ok().body(person);
    }

    @PostMapping("/person")
    public ResponseEntity<Person> addPerson(@Validated @RequestBody Person requestBody, HttpServletRequest request) {
        Principal user = request.getUserPrincipal();
        LOGGER.info("User with name " + user.getName() + "add new person");
        LOGGER.info("Request body:" + requestBody);

        try {
            Person person = personsRepository.save(requestBody);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
        }
    }


    @PutMapping("/person/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable(value = "id") Long personId,
                                               @Validated @RequestBody Person personNew, HttpServletRequest request) throws ResourceNotFoundException {
        Principal user = request.getUserPrincipal();
        LOGGER.info("User with name " + user.getName() + " update person with id " + personId);
        LOGGER.info("Request body:" + personNew);

        Person person = personsRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + personId));

        person.setFullName(personNew.getFullName());
        person.setManager(personNew.getManager());
        person.setName(personNew.getName());
        person.setPhoneNumber(personNew.getPhoneNumber());

        final Person updatedTask = personsRepository.save(person);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/person/{id}")
    public Map<String, Boolean> deletePerson(@PathVariable(value = "id") Long personId, HttpServletRequest request)
            throws ResourceNotFoundException {
        Principal user = request.getUserPrincipal();
        LOGGER.info("User with name " + user.getName() + " delete person with id " + personId);

        Person person = personsRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + personId));

        personsRepository.delete(person);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}

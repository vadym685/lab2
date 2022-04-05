package com.example.lab2.controler.viewControllers.browse;

import com.example.lab2.model.Person;
import com.example.lab2.model.Point;
import com.example.lab2.model.Task;
import com.example.lab2.repository.PersonRepo;
import com.example.lab2.repository.PointRepo;
import com.example.lab2.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class PersonBrowseViewController {
    @Autowired
    private PersonRepo personRepository;

    @RequestMapping(value = {"/personsBrowse"}, method = RequestMethod.GET)
    public ModelAndView viewPersonsBrowse() {
        return new ModelAndView("browse/personsBrowse", Collections.singletonMap("tempPersonMap", personRepository.findAll()));
    }

    @RequestMapping(value = {"/searchPerson"}, method = RequestMethod.GET)
    public ModelAndView getPersons(@RequestParam("searchString") String searchString, String searchField) {
        if (searchField.equals("ID")) {
            ArrayList<Long> arrayList = new ArrayList<>();
            arrayList.add(Long.parseLong(searchString));

            return new ModelAndView("browse/personsBrowse", Collections.singletonMap("tempPersonMap", personRepository.findAllById(arrayList)));
        } else if (searchField.equals("NAME")) {
            return new ModelAndView("browse/personsBrowse", Collections.singletonMap("tempPersonMap", personRepository.findByName(searchString)));
        }
        return new ModelAndView("browse/personsBrowse");
    }

    @RequestMapping(value = {"/deletePerson"}, method = RequestMethod.GET)
    public ModelAndView deletePersonByID(@RequestParam("personID") String personID, Model model) {
        Optional<Person> optionalPerson = personRepository.findById(Long.parseLong(personID));
        Person person = optionalPerson.orElseGet(Person::new);
//
//        List<Task> taskList = taskRepository.findByPoint(point);
//
//        for (Task task : taskList) {
//            task.setPoint(null);
//            taskRepository.save(task);
//        }

        personRepository.deleteById(Long.parseLong(personID));

        return new ModelAndView("redirect:" + "/personsBrowse");
    }
}

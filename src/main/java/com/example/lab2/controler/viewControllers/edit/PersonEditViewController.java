package com.example.lab2.controler.viewControllers.edit;

import com.example.lab2.model.Person;
import com.example.lab2.repository.PersonRepo;
import com.example.lab2.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class PersonEditViewController {

    @Autowired
    private PersonRepo personRepository;
    @Autowired
    private TaskRepo taskRepository;

    @RequestMapping(value = {"/editPerson"}, method = RequestMethod.GET)
    public ModelAndView getPersonByID(@RequestParam("personID") String personID, Model model) {
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.parseLong(personID));

        model.addAttribute("taskID", "");
        return new ModelAndView("edit/personEdit", Collections.singletonMap("tempPersonMap", personRepository.findAllById(arrayList)));
    }

    @RequestMapping(value = {"/saveEditedPersons"}, method = RequestMethod.POST)
    public ModelAndView saveEditedPerson(@ModelAttribute(value = "persons") Person person, Model model, HttpServletRequest request) {

        if (request.getParameter("close") != null) {
            return new ModelAndView("redirect:" + "/personsBrowse");
        }
        if (request.getParameter("save") != null) {
            personRepository.save(person);
            return new ModelAndView("redirect:" + "/editPerson?personID=" + person.getId());
        }
        if (request.getParameter("saveClose") != null) {
            personRepository.save(person);
            return new ModelAndView("redirect:" + "/personsBrowse");
        }

        personRepository.save(person);
        return new ModelAndView("redirect:" + "/personsBrowse");
    }

    @RequestMapping(value = {"/addPerson"}, method = RequestMethod.GET)
    public ModelAndView addNewPerson(Model model) {
        List<Person> arrayList = new ArrayList<>();
        Person person = new Person();

        arrayList.add(person);

        return new ModelAndView("edit/personEdit", Collections.singletonMap("tempPersonMap", arrayList));
    }
}
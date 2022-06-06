package com.example.lab2.controler.viewControllers.edit;

import com.example.lab2.controler.entityСontrollers.PointController;
import com.example.lab2.model.Person;
import com.example.lab2.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class PersonEditViewController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PointController.class);

    @Autowired
    private PersonRepo personRepository;

    @RequestMapping(value = {"/editPerson"}, method = RequestMethod.GET)
    public ModelAndView getPersonByID(@RequestParam("personID") String personID, Model model, HttpServletRequest request) {
        String isAdmin = "";
        if (request.isUserInRole("ROLE_ADMIN")) {
            isAdmin = "<a href=\"/admin\">Admin panel</a>";
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.parseLong(personID));

        model.addAttribute("taskID", "");
        Principal user = request.getUserPrincipal();
        if (user != null) {
            model.addAttribute("isAdmin", isAdmin);
            model.addAttribute("username", user.getName());
        }
        ;
        return new ModelAndView("edit/personEdit", Collections.singletonMap("tempPersonMap", personRepository.findAllById(arrayList)));
    }

    @RequestMapping(value = {"/saveEditedPersons"}, method = RequestMethod.POST)
    public ModelAndView saveEditedPerson(@ModelAttribute(value = "persons") Person person, Model model, HttpServletRequest request) {

        if (request.getParameter("close") != null) {
            return new ModelAndView("redirect:" + "/personsBrowse");
        }

        boolean result = false;
        int counter = 0;
        while (!result) {
            if (counter>=50){
                return new ModelAndView("error/db_error");
            }
            try {
                personRepository.save(person);
                result = true;
            } catch (Exception e) {
                counter++;
            }
        }

        if (request.getParameter("save") != null) {
            return new ModelAndView("redirect:" + "/editPerson?personID=" + person.getId());
        }
        if (request.getParameter("saveClose") != null) {
            return new ModelAndView("redirect:" + "/personsBrowse");
        }
        if (request.getParameter("selectManager") != null) {
            String isAdmin = "";
            if (request.isUserInRole("ROLE_ADMIN")) {
                isAdmin = "<a href=\"/admin\">Admin panel</a>";
            }

            model.addAttribute("personID", person.getId());
            Principal user = request.getUserPrincipal();
            if (user != null) {
                model.addAttribute("isAdmin", isAdmin);
                model.addAttribute("username", user.getName());
            }
            return new ModelAndView("browse/managerSelected", Collections.singletonMap("tempPersonMap", personRepository.findByAdmin(true)));
        }

        return new ModelAndView("redirect:" + "/personsBrowse");
    }

    @RequestMapping(value = {"/addPerson"}, method = RequestMethod.GET)
    public ModelAndView addNewPerson(Model model, HttpServletRequest request) {
        String isAdmin = "";
        if (request.isUserInRole("ROLE_ADMIN")) {
            isAdmin = "<a href=\"/admin\">Admin panel</a>";
        }

        List<Person> arrayList = new ArrayList<>();
        Person person = new Person();

        arrayList.add(person);
        Principal user = request.getUserPrincipal();
        if (user != null) {
            model.addAttribute("isAdmin", isAdmin);
            model.addAttribute("username", user.getName());
        }
        return new ModelAndView("edit/personEdit", Collections.singletonMap("tempPersonMap", arrayList));
    }

    @RequestMapping(value = {"/selectManager"}, method = RequestMethod.GET)
    public ModelAndView selectPoint(@RequestParam("managerID") String managerID, @RequestParam("personID") String personID, Model model, HttpServletRequest request) {
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.parseLong(personID));

        Optional<Person> optionalPerson = personRepository.findById(Long.parseLong(personID));
        Person person = optionalPerson.orElseGet(Person::new);

        Optional<Person> optionalManager = personRepository.findById(Long.parseLong(managerID));
        Person manager = optionalManager.orElseGet(Person::new);

        person.setManager(manager);

        personRepository.save(person);

        String isAdmin = "";
        if (request.isUserInRole("ROLE_ADMIN")) {
            isAdmin = "<a href=\"/admin\">Admin panel</a>";
        }
        Principal user = request.getUserPrincipal();
        if (user != null) {
            model.addAttribute("isAdmin", isAdmin);
            model.addAttribute("username", user.getName());
        }
        return new ModelAndView("edit/personEdit", Collections.singletonMap("tempPersonMap", personRepository.findAllById(arrayList)));
    }

}
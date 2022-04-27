package com.example.lab2.controler.viewControllers.browse;

import com.example.lab2.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;

@Controller
public class PersonBrowseViewController {
    @Autowired
    private PersonRepo personRepository;

    @RequestMapping(value = {"/personsBrowse"}, method = RequestMethod.GET)
    public ModelAndView viewPersonsBrowse(Model model, HttpServletRequest request) {
        String isAdmin = "";
        if (request.isUserInRole("ROLE_ADMIN")) {
            isAdmin = "<a href=\"/admin\">Admin panel</a>";
        }
        model.addAttribute("isAdmin", isAdmin);
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
    public ModelAndView deletePersonByID(@RequestParam("personID") String personID) {
        personRepository.deleteById(Long.parseLong(personID));

        return new ModelAndView("redirect:" + "/personsBrowse");
    }
}

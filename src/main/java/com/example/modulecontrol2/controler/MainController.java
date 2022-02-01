package com.example.modulecontrol2.controler;


import com.example.modulecontrol2.model.Questions;
import com.example.modulecontrol2.model.Users;
import com.example.modulecontrol2.repo.QuestionsRepo;
import com.example.modulecontrol2.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class MainController {

    private static List<Questions> questionsList = new ArrayList<Questions>();

    @Autowired
    private UsersRepo usersRepo;
    @Autowired
    private QuestionsRepo questionsRepo;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {
        questionsList = questionsRepo.findAll();
        return "index";
    }

    @RequestMapping(value = {"/questions"}, method = RequestMethod.GET)
    public String viewQuestions(@RequestParam("search_string") String search_string,Model model) {

        try {
            Users user = (Users) usersRepo.findByName(search_string);
        } catch (Exception e) {
            Users user = new Users(search_string);
            usersRepo.save(user);
        }
        model.addAttribute("questions", questionsList);

        return "questionsList";
    }


}
package com.example.lab2.controler;

import org.springframework.stereotype.Controller;


@Controller
public class MainController {

//    private static List<Questions> questionsList = new ArrayList<Questions>();
//
//    @Autowired
//    private UsersRepo usersRepo;
//    @Autowired
//    private QuestionsRepo questionsRepo;
//
//    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
//    public String index(Model model) {
//        questionsList = questionsRepo.findAll();
//        return "index";
//    }
//
//    @RequestMapping(value = {"/questions"}, method = RequestMethod.GET)
//    public String viewQuestions(@RequestParam("search_string") String search_string,Model model) {
//
//        try {
//            Users user = (Users) usersRepo.findByName(search_string);
//        } catch (Exception e) {
//            Users user = new Users(search_string);
//            usersRepo.save(user);
//        }
//        model.addAttribute("questions", questionsList);
//
//        return "questionsList";
//    }


}
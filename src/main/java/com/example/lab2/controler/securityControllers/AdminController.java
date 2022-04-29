package com.example.lab2.controler.securityControllers;

import com.example.lab2.controler.entityСontrollers.PointController;
import com.example.lab2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class AdminController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    public ModelAndView userList(Model model, HttpServletRequest request) {
        String isAdmin = "";
        if (request.isUserInRole("ROLE_ADMIN")) {
            isAdmin = "<a href=\"/admin\">Admin panel</a>";
        }
        Principal user = request.getUserPrincipal();
        if (user != null) {
            model.addAttribute("isAdmin", isAdmin);
            model.addAttribute("username", user.getName());
        }
        model.addAttribute("allUsers", userService.allUsers());
        return new ModelAndView("security/admin");
    }

    @PostMapping("/admin")
    public ModelAndView deleteUser(@RequestParam(required = true, defaultValue = "") Long userId,
                                   @RequestParam(required = true, defaultValue = "") String action,
                                   Model model) {
        if (action.equals("delete")) {
            userService.deleteUser(userId);
        }
        return new ModelAndView("redirect:" + "/admin");
    }

    @GetMapping("/admin/gt/{userId}")
    public ModelAndView gtUser(@PathVariable("userId") Long userId, Model model) {
        model.addAttribute("allUsers", userService.usergtList(userId));
        return new ModelAndView("security/admin");
    }

    @GetMapping("/logoutApp")
    public ModelAndView logoutApp(Model model) {
        return new ModelAndView("redirect:" + "/logout");
    }
}
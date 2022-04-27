package com.example.lab2.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;


@Controller
public class MainController {

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {
        String isAdmin = "";
        if (request.isUserInRole("ROLE_ADMIN")) {
            isAdmin = "<a href=\"/admin\">Admin panel</a>";
        }
        Principal user = request.getUserPrincipal();
        if (user != null) {
            model.addAttribute("isAdmin", isAdmin);
            model.addAttribute("username", user.getName());
        }
        return "index";
    }


}
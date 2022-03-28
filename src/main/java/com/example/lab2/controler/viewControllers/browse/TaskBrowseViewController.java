package com.example.lab2.controler.viewControllers.browse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskBrowseViewController {
    @RequestMapping(value = {"/tasksBrowse"}, method = RequestMethod.GET)
    public String viewpointsBrowse() {
        return "pointsBrowse";
    }
}

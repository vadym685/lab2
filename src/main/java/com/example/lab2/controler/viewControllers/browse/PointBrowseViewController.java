package com.example.lab2.controler.viewControllers.browse;

import com.example.lab2.repository.PointRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.Collections;

@Controller
public class PointBrowseViewController {
    @Autowired
    private PointRepo pointRepository;

    @RequestMapping(value = {"/pointsBrowse"}, method = RequestMethod.GET)
    public ModelAndView viewpointsBrowse() {
        return new ModelAndView("pointsBrowse",Collections.singletonMap("tempPointsMap",pointRepository.findAll()));
    }
}

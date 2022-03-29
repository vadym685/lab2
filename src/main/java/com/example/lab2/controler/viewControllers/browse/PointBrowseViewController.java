package com.example.lab2.controler.viewControllers.browse;

import com.example.lab2.repository.PointRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Controller
public class PointBrowseViewController {
    @Autowired
    private PointRepo pointRepository;

    @RequestMapping(value = {"/pointsBrowse"}, method = RequestMethod.GET)
    public ModelAndView viewpointsBrowse() {

        return new ModelAndView("browse/pointsBrowse",Collections.singletonMap("tempPointsMap",pointRepository.findAll()));

    }

    @RequestMapping(value = {"/searchPointByID"}, method = RequestMethod.GET)
    public ModelAndView getPointByID(@RequestParam("search_string") String search_string, Model model) {

        ArrayList<Long> arrayList = new ArrayList<Long>();
        arrayList.add(Long.parseLong(search_string));

        return new ModelAndView("browse/pointsBrowse",Collections.singletonMap("tempPointsMap",pointRepository.findAllById(arrayList)));
    }
}

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
import java.util.Collections;

@Controller
public class PointBrowseViewController {
    @Autowired
    private PointRepo pointRepository;

    @RequestMapping(value = {"/pointsBrowse"}, method = RequestMethod.GET)
    public ModelAndView viewpointsBrowse() {
        return new ModelAndView("browse/pointsBrowse", Collections.singletonMap("tempPointsMap", pointRepository.findAll()));
    }

    @RequestMapping(value = {"/searchPoint"}, method = RequestMethod.GET)
    public ModelAndView getPoint(@RequestParam("searchString") String searchString, String searchField) {
        if (searchField.equals("ID") ) {
            ArrayList<Long> arrayList = new ArrayList<>();
            arrayList.add(Long.parseLong(searchString));

            return new ModelAndView("browse/pointsBrowse", Collections.singletonMap("tempPointsMap", pointRepository.findAllById(arrayList)));
        }else if (searchField.equals("NAME")){
            return new ModelAndView("browse/pointsBrowse", Collections.singletonMap("tempPointsMap", pointRepository.findByName(searchString)));
        }
        return new ModelAndView("browse/pointsBrowse");
    }

    @RequestMapping(value = {"/deletePoint"}, method = RequestMethod.GET)
    public ModelAndView deletePointByID(@RequestParam("pointID") String pointID, Model model) {
        pointRepository.deleteById(Long.parseLong(pointID));

        return new ModelAndView("redirect:" + "/pointsBrowse");
    }
}

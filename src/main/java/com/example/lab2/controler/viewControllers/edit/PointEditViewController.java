package com.example.lab2.controler.viewControllers.edit;

import com.example.lab2.model.Point;
import com.example.lab2.repository.PointRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Controller
public class PointEditViewController {
    @Autowired
    private PointRepo pointRepository;

    @RequestMapping(value = {"/editPoint"}, method = RequestMethod.GET)
    public ModelAndView getPointByID(@RequestParam("pointID") String pointID, Model model) {
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.parseLong(pointID));

        return new ModelAndView("edit/pointEdit", Collections.singletonMap("tempPoint", pointRepository.findAllById(arrayList)));
    }

    @RequestMapping(value = {"/saveEditedPoint"}, method = RequestMethod.POST)
    public ModelAndView saveEditedPoint(@ModelAttribute("point") Point point, Model model) {
        pointRepository.save(point);
        return new ModelAndView("redirect:" + "/pointsBrowse");
//        return new ModelAndView("browse/pointsBrowse", Collections.singletonMap("tempPointsMap", pointRepository.findAll()));
    }

    @RequestMapping(value = {"/addPoint"}, method = RequestMethod.GET)
    public ModelAndView addNewPoint() {
        List<Point> arrayList = new ArrayList<>();
        arrayList.add(new Point());

        return new ModelAndView("edit/pointEdit", Collections.singletonMap("tempPoint", arrayList));
    }
}

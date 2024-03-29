package com.example.lab2.controler.viewControllers.edit;

import com.example.lab2.controler.entityСontrollers.PointController;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Controller
public class PointEditViewController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PointController.class);

    @Autowired
    private PointRepo pointRepository;

    @RequestMapping(value = {"/editPoint"}, method = RequestMethod.GET)
    public ModelAndView getPointByID(@RequestParam("pointID") String pointID, Model model, HttpServletRequest request) {
        String isAdmin = "";
        if (request.isUserInRole("ROLE_ADMIN")) {
            isAdmin = "<a href=\"/admin\">Admin panel</a>";
        }

        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.parseLong(pointID));

        Principal user = request.getUserPrincipal();
        if (user != null) {
            model.addAttribute("isAdmin", isAdmin);
            model.addAttribute("username", user.getName());
        }
        return new ModelAndView("edit/pointEdit", Collections.singletonMap("tempPoint", pointRepository.findAllById(arrayList)));
    }

    @RequestMapping(value = {"/saveEditedPoint"}, method = RequestMethod.POST)
    public ModelAndView saveEditedPoint(@ModelAttribute("point") Point point, HttpServletRequest request) throws Exception {
        if (request.getParameter("close") != null) {
            return new ModelAndView("redirect:" + "/pointsBrowse");
        }

        boolean result = false;
        int counter = 0;
        while (!result) {
            if (counter>=50){
                return new ModelAndView("error/db_error");
            }
            try {
                pointRepository.save(point);
                result = true;
            } catch (Exception e) {
                counter++;
            }
        }

        if (request.getParameter("save") != null) {
            return new ModelAndView("redirect:" + "/editPoint?pointID=" + point.getId());
        }
        if (request.getParameter("saveClose") != null) {
            return new ModelAndView("redirect:" + "/pointsBrowse");
        }

        return new ModelAndView("redirect:" + "/pointsBrowse");
    }

    @RequestMapping(value = {"/addPoint"}, method = RequestMethod.GET)
    public ModelAndView addNewPoint(Model model, HttpServletRequest request) {
        String isAdmin = "";
        if (request.isUserInRole("ROLE_ADMIN")) {
            isAdmin = "<a href=\"/admin\">Admin panel</a>";
        }

        List<Point> arrayList = new ArrayList<>();
        Point point = new Point();

        arrayList.add(point);

        Principal user = request.getUserPrincipal();
        if (user != null) {
            model.addAttribute("isAdmin", isAdmin);
            model.addAttribute("username", user.getName());
        }
        return new ModelAndView("edit/pointEdit", Collections.singletonMap("tempPoint", arrayList));
    }
}

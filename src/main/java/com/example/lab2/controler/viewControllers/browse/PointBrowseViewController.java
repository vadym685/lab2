package com.example.lab2.controler.viewControllers.browse;

import com.example.lab2.model.Point;
import com.example.lab2.model.Task;
import com.example.lab2.repository.PointRepo;
import com.example.lab2.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class PointBrowseViewController {
    @Autowired
    private PointRepo pointRepository;

    @Autowired
    private TaskRepo taskRepository;

    @RequestMapping(value = {"/pointsBrowse"}, method = RequestMethod.GET)
    public ModelAndView viewpointsBrowse() {
        return new ModelAndView("browse/pointsBrowse", Collections.singletonMap("tempPointsMap", pointRepository.findAll()));
    }

    @RequestMapping(value = {"/searchPoint"}, method = RequestMethod.GET)
    public ModelAndView getPoint(@RequestParam("searchString") String searchString, String searchField) {
        if (searchField.equals("ID")) {
            ArrayList<Long> arrayList = new ArrayList<>();
            arrayList.add(Long.parseLong(searchString));

            return new ModelAndView("browse/pointsBrowse", Collections.singletonMap("tempPointsMap", pointRepository.findAllById(arrayList)));
        } else if (searchField.equals("NAME")) {
            return new ModelAndView("browse/pointsBrowse", Collections.singletonMap("tempPointsMap", pointRepository.findByName(searchString)));
        }
        return new ModelAndView("browse/pointsBrowse");
    }

    @RequestMapping(value = {"/deletePoint"}, method = RequestMethod.GET)
    public ModelAndView deletePointByID(@RequestParam("pointID") String pointID, Model model) {
        Optional<Point> optionalPoint = pointRepository.findById(Long.parseLong(pointID));
        Point point = optionalPoint.orElseGet(Point::new);

        List<Task> taskList = taskRepository.findByPoint(point);

        for (Task task : taskList) {
            task.setPoint(null);
            taskRepository.save(task);
        }

        pointRepository.deleteById(Long.parseLong(pointID));

        return new ModelAndView("redirect:" + "/pointsBrowse");
    }
}

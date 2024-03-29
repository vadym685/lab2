package com.example.lab2.controler.viewControllers.edit;

import com.example.lab2.controler.entityСontrollers.PointController;
import com.example.lab2.model.Position;
import com.example.lab2.model.Task;
import com.example.lab2.repository.PositionRepo;
import com.example.lab2.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class PositionEditViewController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PointController.class);

    @Autowired
    private PositionRepo positionRepo;
    @Autowired
    private TaskRepo taskRepository;

    @RequestMapping(value = {"/editPosition"}, method = RequestMethod.GET)
    public ModelAndView getPositionByID(@RequestParam("taskID") String taskID, @RequestParam("positionID") String positionID, Model model, HttpServletRequest request) {
        String isAdmin = "";
        if (request.isUserInRole("ROLE_ADMIN")) {
            isAdmin = "<a href=\"/admin\">Admin panel</a>";
        }

        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.parseLong(taskID));

        model.addAttribute("taskID", taskID);
        Principal user = request.getUserPrincipal();
        if (user != null) {
            model.addAttribute("isAdmin", isAdmin);
            model.addAttribute("username", user.getName());
        }
        return new ModelAndView("edit/positionEdit", Collections.singletonMap("tempPosition", positionRepo.findAllById(arrayList)));
    }

    @RequestMapping(value = {"/saveEditedPosition"}, method = RequestMethod.POST)
    public ModelAndView saveEditedPosition(@ModelAttribute(value = "position") Position position, @RequestParam("taskID") String taskID, Model model, HttpServletRequest request) {
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.parseLong(taskID));

        Optional<Task> optionalTask = taskRepository.findById(Long.parseLong(taskID));
        Task task = optionalTask.orElseGet(Task::new);

        if (request.getParameter("close") != null) {
            return new ModelAndView("redirect:" + "/editTask?taskID=" + task.getId());
        }
        if (request.getParameter("saveClose") != null) {
            position.setTask(task);
            taskRepository.save(task);
            positionRepo.save(position);

            return new ModelAndView("redirect:" + "/editTask?taskID=" + task.getId());
        }

        position.setTask(task);
        positionRepo.save(position);

        return new ModelAndView("redirect:" + "/editTask?taskID=" + task.getId());
    }

    @RequestMapping(value = {"/deletePosition"}, method = RequestMethod.GET)
    public ModelAndView deletePositionByID(@RequestParam("positionID") String positionID, @RequestParam("taskID") String taskID, Model model, HttpServletRequest request) {
        String isAdmin = "";
        if (request.isUserInRole("ROLE_ADMIN")) {
            isAdmin = "<a href=\"/admin\">Admin panel</a>";
        }

        positionRepo.deleteById(Long.parseLong(positionID));

        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.parseLong(taskID));

        model.addAttribute("taskID", taskID);
        Principal user = request.getUserPrincipal();
        if (user != null) {
            model.addAttribute("isAdmin", isAdmin);
            model.addAttribute("username", user.getName());
        }
        return new ModelAndView("edit/taskEdit", Collections.singletonMap("tempTask", taskRepository.findAllById(arrayList)));
    }

    @RequestMapping(value = {"/addPosition"}, method = RequestMethod.GET)
    public ModelAndView addNewPosition(@RequestParam("taskID") String taskID, Model model, HttpServletRequest request) {
        String isAdmin = "";
        if (request.isUserInRole("ROLE_ADMIN")) {
            isAdmin = "<a href=\"/admin\">Admin panel</a>";
        }

        List<Position> arrayList = new ArrayList<>();
        Position position = new Position();

        arrayList.add(position);
        model.addAttribute("taskID", taskID);
        Principal user = request.getUserPrincipal();
        if (user != null) {
            model.addAttribute("isAdmin", isAdmin);
            model.addAttribute("username", user.getName());
        }
        return new ModelAndView("edit/positionEdit", Collections.singletonMap("tempPosition", arrayList));
    }
}

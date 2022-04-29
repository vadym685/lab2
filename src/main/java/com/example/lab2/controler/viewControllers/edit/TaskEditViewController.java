package com.example.lab2.controler.viewControllers.edit;

import com.example.lab2.controler.entityСontrollers.PointController;
import com.example.lab2.model.Person;
import com.example.lab2.model.Point;
import com.example.lab2.model.Task;
import com.example.lab2.repository.PersonRepo;
import com.example.lab2.repository.PointRepo;
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
public class TaskEditViewController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PointController.class);

    @Autowired
    private TaskRepo taskRepository;
    @Autowired
    private PointRepo pointRepository;
    @Autowired
    private PersonRepo personRepository;

    @RequestMapping(value = {"/editTask"}, method = RequestMethod.GET)
    public ModelAndView getTaskByID(@RequestParam("taskID") String taskID, Model model, HttpServletRequest request) {
        String isAdmin = "";
        if (request.isUserInRole("ROLE_ADMIN")) {
            isAdmin = "<a href=\"/admin\">Admin panel</a>";
        }

        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.parseLong(taskID));

        Principal user = request.getUserPrincipal();
        if (user != null) {
            model.addAttribute("isAdmin", isAdmin);
            model.addAttribute("username", user.getName());
        }
        return new ModelAndView("edit/taskEdit", Collections.singletonMap("tempTask", taskRepository.findAllById(arrayList)));
    }

    @RequestMapping(value = {"/saveEditedTask"}, method = RequestMethod.POST)
    public ModelAndView saveEditedTask(@ModelAttribute(value = "task") Task task, Model model, HttpServletRequest request) {
        String isAdmin = "";
        if (request.isUserInRole("ROLE_ADMIN")) {
            isAdmin = "<a href=\"/admin\">Admin panel</a>";
        }

        if (request.getParameter("close") != null) {
            return new ModelAndView("redirect:" + "/tasksBrowse");
        }

        if (task.getId() != 0) {
            List<Person> personList = personRepository.findByTasksIsContaining(task);
            task.setPersons(personList);
        }

        taskRepository.save(task);

        if (request.getParameter("save") != null) {
            return new ModelAndView("redirect:" + "/editTask?taskID=" + task.getId());
        }
        if (request.getParameter("saveClose") != null) {
            return new ModelAndView("redirect:" + "/tasksBrowse");
        }
        if (request.getParameter("saveAndAddPosition") != null) {
            return new ModelAndView("redirect:" + "/addPosition?taskID=" + task.getId());
        }
        if (request.getParameter("saveAndAddConsumables") != null) {
            return new ModelAndView("redirect:" + "/addConsumables?taskID=" + task.getId());
        }
        if (request.getParameter("selectPoint") != null) {
            model.addAttribute("taskID", task.getId());
            Principal user = request.getUserPrincipal();
            if (user != null) {
                model.addAttribute("isAdmin", isAdmin);
                model.addAttribute("username", user.getName());
            }
            return new ModelAndView("browse/pointsSelected", Collections.singletonMap("tempPointsMap", pointRepository.findAll()));
        }
        if (request.getParameter("selectPerson") != null) {
            model.addAttribute("taskID", task.getId());
            Principal user = request.getUserPrincipal();
            if (user != null) {
                model.addAttribute("isAdmin", isAdmin);
                model.addAttribute("username", user.getName());
            }
            return new ModelAndView("browse/personsSelected", Collections.singletonMap("tempPersonMap", personRepository.findAll()));
        }

        return new ModelAndView("redirect:" + "/tasksBrowse");
    }

    @RequestMapping(value = {"/addTask"}, method = RequestMethod.GET)
    public ModelAndView addNewTask(Model model, HttpServletRequest request) {
        String isAdmin = "";
        if (request.isUserInRole("ROLE_ADMIN")) {
            isAdmin = "<a href=\"/admin\">Admin panel</a>";
        }

        Task task = new Task();

        List<Task> arrayList = new ArrayList<>();
        arrayList.add(task);

        Principal user = request.getUserPrincipal();
        if (user != null) {
            model.addAttribute("isAdmin", isAdmin);
            model.addAttribute("username", user.getName());
        }
        return new ModelAndView("edit/taskEdit", Collections.singletonMap("tempTask", arrayList));
    }

    @RequestMapping(value = {"/selectPoint"}, method = RequestMethod.GET)
    public ModelAndView selectPoint(@RequestParam("taskID") String taskID, @RequestParam("pointID") String pointID, Model model, HttpServletRequest request) {
        String isAdmin = "";
        if (request.isUserInRole("ROLE_ADMIN")) {
            isAdmin = "<a href=\"/admin\">Admin panel</a>";
        }

        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.parseLong(taskID));

        Optional<Point> optionalPoint = pointRepository.findById(Long.parseLong(pointID));
        Point point = optionalPoint.orElseGet(Point::new);

        Optional<Task> optionalTask = taskRepository.findById(Long.parseLong(taskID));
        Task task = optionalTask.orElseGet(Task::new);

        task.setPoint(point);

        taskRepository.save(task);

        Principal user = request.getUserPrincipal();
        if (user != null) {
            model.addAttribute("isAdmin", isAdmin);
            model.addAttribute("username", user.getName());
        }
        return new ModelAndView("edit/taskEdit", Collections.singletonMap("tempTask", taskRepository.findAllById(arrayList)));
    }

    @RequestMapping(value = {"/selectPerson"}, method = RequestMethod.GET)
    public ModelAndView selectPerson(@RequestParam("taskID") String taskID, @RequestParam("personID") String personID, Model model, HttpServletRequest request) {
        String isAdmin = "";
        if (request.isUserInRole("ROLE_ADMIN")) {
            isAdmin = "<a href=\"/admin\">Admin panel</a>";
        }

        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.parseLong(taskID));

        Optional<Task> optionalTask = taskRepository.findById(Long.parseLong(taskID));
        Task task = optionalTask.orElseGet(Task::new);

        Optional<Person> optionalPerson = personRepository.findById(Long.parseLong(personID));
        Person person = optionalPerson.orElseGet(Person::new);

        List<Person> personList = personRepository.findByTasksIsContaining(task);
        personList.add(person);
        task.setPersons(personList);

        taskRepository.save(task);

        Principal user = request.getUserPrincipal();
        if (user != null) {
            model.addAttribute("isAdmin", isAdmin);
            model.addAttribute("username", user.getName());
        }
        return new ModelAndView("edit/taskEdit", Collections.singletonMap("tempTask", taskRepository.findAllById(arrayList)));
    }

}

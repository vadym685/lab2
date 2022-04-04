package com.example.lab2.controler.viewControllers.browse;

import com.example.lab2.model.Task;
import com.example.lab2.repository.ConsumablesRepo;
import com.example.lab2.repository.PointRepo;
import com.example.lab2.repository.PositionRepo;
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
import java.util.Optional;

@Controller
public class TaskBrowseViewController {

    @Autowired
    private TaskRepo taskRepository;

    @Autowired
    private PositionRepo positionRepository;

    @Autowired
    private ConsumablesRepo consumablesRepository;

    @RequestMapping(value = {"/tasksBrowse"}, method = RequestMethod.GET)
    public ModelAndView viewTasksBrowse() {
        return new ModelAndView("browse/tasksBrowse", Collections.singletonMap("tempTasksMap", taskRepository.findAll()));
    }


    @RequestMapping(value = {"/searchTask"}, method = RequestMethod.GET)
    public ModelAndView getPoint(@RequestParam("searchString") String searchString, String searchField) {
        if (searchField.equals("ID") ) {
            ArrayList<Long> arrayList = new ArrayList<>();
            arrayList.add(Long.parseLong(searchString));

            return new ModelAndView("browse/tasksBrowse", Collections.singletonMap("tempTasksMap", taskRepository.findAllById(arrayList)));

        }
        return new ModelAndView("browse/tasksBrowse");
    }

    @RequestMapping(value = {"/deleteTask"}, method = RequestMethod.GET)
    public ModelAndView deleteTaskByID(@RequestParam("taskID") String taskID, Model model) {
        Optional<Task> optionalTask = taskRepository.findById(Long.parseLong(taskID));
        Task task = optionalTask.orElseGet(Task::new);

        positionRepository.deleteAll(positionRepository.findByTask(task));
        consumablesRepository.deleteAll(consumablesRepository.findByTask(task));

        taskRepository.deleteById(Long.parseLong(taskID));

        return new ModelAndView("redirect:" + "/tasksBrowse");
    }

}

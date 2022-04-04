package com.example.lab2.controler.viewControllers.edit;

import com.example.lab2.model.Task;
import com.example.lab2.repository.PositionRepo;
import com.example.lab2.repository.TaskRepo;
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
public class TaskEditViewController {
    @Autowired
    private TaskRepo taskRepository;
    @Autowired
    private PositionRepo positionRepo;

    @RequestMapping(value = {"/editTask"}, method = RequestMethod.GET)
    public ModelAndView getTaskByID(@RequestParam("taskID") String taskID, Model model) {
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.parseLong(taskID));

        return new ModelAndView("edit/taskEdit", Collections.singletonMap("tempTask", taskRepository.findAllById(arrayList)));
    }

    @RequestMapping(value = {"/saveEditedTask"}, method = RequestMethod.POST)
    public ModelAndView saveEditedTask(@ModelAttribute(value = "task") Task task, Model model) {
        taskRepository.save(task);
        return new ModelAndView("redirect:" + "/tasksBrowse");
    }

    @RequestMapping(value = {"/addTask"}, method = RequestMethod.GET)
    public ModelAndView addNewTask(Model model) {
        List<Task> arrayList = new ArrayList<>();
        arrayList.add(new Task());

        return new ModelAndView("edit/taskEdit", Collections.singletonMap("tempTask", arrayList));
    }


}

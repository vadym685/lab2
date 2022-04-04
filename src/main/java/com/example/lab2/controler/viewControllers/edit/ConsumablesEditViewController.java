package com.example.lab2.controler.viewControllers.edit;

import com.example.lab2.model.Consumables;
import com.example.lab2.model.Task;
import com.example.lab2.repository.ConsumablesRepo;
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
import java.util.Optional;

@Controller
public class ConsumablesEditViewController {

    @Autowired
    private ConsumablesRepo consumablesRepo;

    @Autowired
    private TaskRepo taskRepository;

    @RequestMapping(value = {"/editConsumables"}, method = RequestMethod.GET)
    public ModelAndView getConsumablesByID(@RequestParam("taskID") String taskID, @RequestParam("consumablesID") String consumablesID, Model model) {
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.parseLong(taskID));

        model.addAttribute("taskID", taskID);
        return new ModelAndView("edit/consumablesEdit", Collections.singletonMap("tempConsumables", consumablesRepo.findAllById(arrayList)));
    }

    @RequestMapping(value = {"/saveEditedConsumables"}, method = RequestMethod.POST)
    public ModelAndView saveEditedConsumables(@ModelAttribute(value = "task") Consumables consumables, @RequestParam("taskID") String taskID, Model model) {
        consumablesRepo.save(consumables);

        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.parseLong(taskID));

        Optional<Task> optionalTask = taskRepository.findById(Long.parseLong(taskID));
        Task task = optionalTask.orElseGet(Task::new);

        taskRepository.save(task);
        consumables.setTask(task);
        consumablesRepo.save(consumables);

        return new ModelAndView("redirect:" + "/editTask?taskID=" +task.getId());
    }

    @RequestMapping(value = {"/deleteConsumables"}, method = RequestMethod.GET)
    public ModelAndView deleteConsumablesByID(@RequestParam("consumablesID") String consumablesID, @RequestParam("taskID") String taskID, Model model) {
        consumablesRepo.deleteById(Long.parseLong(consumablesID));

        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.parseLong(taskID));

        model.addAttribute("taskID", taskID);
        return new ModelAndView("edit/taskEdit", Collections.singletonMap("tempTask", taskRepository.findAllById(arrayList)));
    }

    @RequestMapping(value = {"/addConsumables"}, method = RequestMethod.GET)
    public ModelAndView addNewConsumables(@RequestParam("taskID") String taskID, Model model) {
        List<Consumables> arrayList = new ArrayList<>();
        Consumables consumables = new Consumables();
        consumables.setTask(taskRepository.getById(Long.parseLong(taskID)));

        arrayList.add(consumables);
        model.addAttribute("taskID", taskID);


        return new ModelAndView("edit/consumablesEdit", Collections.singletonMap("tempConsumables", arrayList));
    }
}

package com.example.lab2.controler.viewControllers.edit;

import com.example.lab2.model.Position;
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
import java.util.Optional;

@Controller
public class PositionEditViewController {
    @Autowired
    private PositionRepo positionRepo;

    @Autowired
    private TaskRepo taskRepository;

    @RequestMapping(value = {"/editPosition"}, method = RequestMethod.GET)
    public ModelAndView getTaskByID(@RequestParam("taskID") String taskID, @RequestParam("positionID") String positionID, Model model) {
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.parseLong(taskID));

        model.addAttribute("taskID", taskID);
        return new ModelAndView("edit/positionEdit", Collections.singletonMap("tempPosition", positionRepo.findAllById(arrayList)));
    }

    @RequestMapping(value = {"/saveEditedPosition"}, method = RequestMethod.POST)
    public ModelAndView saveEditedTask(@ModelAttribute(value = "task") Position position, @RequestParam("taskID") String taskID, Model model) {
        positionRepo.save(position);

        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.parseLong(taskID));

        Optional<Task> optionalTask = taskRepository.findById(Long.parseLong(taskID));
        Task task = optionalTask.orElseGet(Task::new);

        taskRepository.save(task);
        position.setTask(task);
        positionRepo.save(position);

        return new ModelAndView("redirect:" + "/editTask?taskID=" +task.getId());
    }

    @RequestMapping(value = {"/deletePosition"}, method = RequestMethod.GET)
    public ModelAndView deleteTaskByID(@RequestParam("positionID") String positionID, @RequestParam("taskID") String taskID, Model model) {
        positionRepo.deleteById(Long.parseLong(positionID));

        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.parseLong(taskID));

        model.addAttribute("taskID", taskID);
        return new ModelAndView("edit/taskEdit", Collections.singletonMap("tempTask", taskRepository.findAllById(arrayList)));
    }

    @RequestMapping(value = {"/addPosition"}, method = RequestMethod.GET)
    public ModelAndView addNewTask(@RequestParam("taskID") String taskID, Model model) {
        List<Position> arrayList = new ArrayList<>();
        Position position = new Position();
        position.setTask(taskRepository.getById(Long.parseLong(taskID)));

        arrayList.add(position);
        model.addAttribute("taskID", taskID);


        return new ModelAndView("edit/positionEdit", Collections.singletonMap("tempPosition", arrayList));
    }
}

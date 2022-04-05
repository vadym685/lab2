package com.example.lab2.controler.viewControllers.edit;

import com.example.lab2.model.Person;
import com.example.lab2.model.Task;
import com.example.lab2.repository.PersonRepo;
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
public class PersonEditViewController {

    @Autowired
    private PersonRepo personRepository;
    @Autowired
    private TaskRepo taskRepository;

    @RequestMapping(value = {"/editPerson"}, method = RequestMethod.GET)
    public ModelAndView getPersonByID(@RequestParam("personID") String personID, Model model) {
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.parseLong(personID));

        model.addAttribute("taskID", "");
        return new ModelAndView("edit/personEdit", Collections.singletonMap("tempPersonMap", personRepository.findAllById(arrayList)));
    }

    @RequestMapping(value = {"/saveEditedPersons"}, method = RequestMethod.POST)
    public ModelAndView saveEditedPerson(@ModelAttribute(value = "persons") Person person, @RequestParam("taskID") String taskID, Model model) {

        if (!taskID.isEmpty()) {

            ArrayList<Long> arrayList = new ArrayList<>();
            arrayList.add(Long.parseLong(taskID));

            Optional<Task> optionalTask = taskRepository.findById(Long.parseLong(taskID));
            Task task = optionalTask.orElseGet(Task::new);

            taskRepository.save(task);
            List<Task> tasksList = person.getTasks();
            tasksList.add(task);

            person.setTasks(tasksList);

            personRepository.save(person);

            return new ModelAndView("redirect:" + "/editPerson?taskID=" + task.getId());
        } else {
            personRepository.save(person);
            return new ModelAndView("redirect:" + "/personsBrowse");
        }

    }

    @RequestMapping(value = {"/addPerson"}, method = RequestMethod.GET)
    public ModelAndView addNewPerson(Model model) {
        List<Person> arrayList = new ArrayList<>();
        Person person = new Person();

        arrayList.add(person);
        model.addAttribute("taskID", "");

        return new ModelAndView("edit/personEdit", Collections.singletonMap("tempPersonMap", arrayList));
    }
}
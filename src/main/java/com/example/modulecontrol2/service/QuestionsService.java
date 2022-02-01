package com.example.modulecontrol2.service;



import com.example.modulecontrol2.model.Questions;
import com.example.modulecontrol2.repo.QuestionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionsService {

    @Autowired
    private final QuestionsRepo questionsRepo;

    public QuestionsService(QuestionsRepo questionsRepo) {
        this.questionsRepo = questionsRepo;
    }

    public void createPerson(Questions user) {
        questionsRepo.save(user);
    }


    public List<Questions> findAll(){
        return questionsRepo.findAll();
    }

}

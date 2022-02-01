package com.example.modulecontrol2.repo;

import com.example.modulecontrol2.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;


public interface QuestionsRepo extends JpaRepository<Questions, Long> {
}

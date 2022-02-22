package com.example.lab2.repository;

import com.example.lab2.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo  extends JpaRepository<Task, Long> {
}

package com.example.lab2.repository;

import com.example.lab2.model.Point;
import com.example.lab2.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo  extends JpaRepository<Task, Long> {
    public List<Task> findByPoint(Point point);
}

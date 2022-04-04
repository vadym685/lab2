package com.example.lab2.repository;

import com.example.lab2.model.Position;
import com.example.lab2.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepo  extends JpaRepository<Position, Long> {
    public List<Position> findByTask(Task task);
}

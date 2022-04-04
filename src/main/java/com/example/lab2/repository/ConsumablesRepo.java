package com.example.lab2.repository;

import com.example.lab2.model.Consumables;
import com.example.lab2.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumablesRepo extends JpaRepository<Consumables, Long> {
    public List<Consumables> findByTask(Task task);
}

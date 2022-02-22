package com.example.lab2.repository;

import com.example.lab2.model.Consumables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumablesRepo extends JpaRepository<Consumables, Long> {
}

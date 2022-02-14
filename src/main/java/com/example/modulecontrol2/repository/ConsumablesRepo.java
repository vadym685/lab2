package com.example.modulecontrol2.repository;

import com.example.modulecontrol2.model.Consumables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumablesRepo extends JpaRepository<Consumables, Long> {
}

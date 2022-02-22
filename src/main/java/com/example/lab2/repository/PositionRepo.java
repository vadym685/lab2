package com.example.lab2.repository;


import com.example.lab2.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepo  extends JpaRepository<Position, Long> {
}

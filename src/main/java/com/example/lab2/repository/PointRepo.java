package com.example.lab2.repository;

import com.example.lab2.model.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PointRepo  extends JpaRepository<Point, Long> {

    public List<Point> findByName(String name);

    public Optional<Point> findById(Long id);

}

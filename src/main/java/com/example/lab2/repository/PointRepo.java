package com.example.lab2.repository;


import com.example.lab2.model.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRepo  extends JpaRepository<Point, Long> {

}

package com.example.modulecontrol2.repository;


import com.example.modulecontrol2.model.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRepo  extends JpaRepository<Point, Long> {
}

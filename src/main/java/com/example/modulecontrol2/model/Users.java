package com.example.modulecontrol2.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    @Column
    private String name;
    @Column
    private double max_total_points = 0;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public Users(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMax_total_points() {
        return max_total_points;
    }

    public void setMax_total_points(double max_total_points) {
        this.max_total_points = max_total_points;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

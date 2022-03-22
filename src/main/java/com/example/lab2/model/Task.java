package com.example.lab2.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Table(name = "TASK", indexes = {
        @Index(name = "IDX_TASK_POINT_ID", columnList = "POINT_ID")
})
@Entity
public class Task {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    @Id
    private long  id;

    @Column(name = "DATE")
    @JsonProperty("date")
    private LocalDate date;

    @JoinColumn(name = "POINT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Point point;

    @JsonProperty("pointID")
    private String pointID;

    @OneToMany(mappedBy = "task")
    @JsonProperty("positions")
    private List<Position> positions;

    @JoinTable(name = "TASK_PERSON_LINK",
            joinColumns = @JoinColumn(name = "TASK_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "PERSON_ID", referencedColumnName = "ID"))
    @ManyToMany
    @JsonProperty("persons")
    private List<Person> persons;

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long  getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPointID() {
        return pointID;
    }

    public void setPointID(String pointID) {
        this.pointID = pointID;
    }
}
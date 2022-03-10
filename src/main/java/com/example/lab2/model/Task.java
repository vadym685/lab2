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
    @GeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "OUTER_ID")
    @JsonProperty("outerID")
    private String outerID;

    @Column(name = "DATE")
    @JsonProperty("date")
    private LocalDate date;

    @JoinColumn(name = "POINT_ID")
    @JsonProperty("pointID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Point point;

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

    public String getOuterID() {
        return outerID;
    }

    public void setOuterID(String outerID) {
        this.outerID = outerID;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
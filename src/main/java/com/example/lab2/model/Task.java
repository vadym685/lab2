package com.example.lab2.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "TASK", indexes = {
        @Index(name = "IDX_TASK_POINT_ID", columnList = "POINT_ID")
})
@Entity
@Data
public class Task {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    @Id
    private long  id;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Column(name = "DATE")
    @JsonProperty("date")
    private Date date;

    @JoinColumn(name = "POINT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Point point;

    @JsonProperty("pointID")
    private String pointID;

    @OneToMany(mappedBy = "task")
    @JsonProperty("positions")
    private List<Position> positions;

    @OneToMany(mappedBy = "task")
    @JsonProperty("consumables")
    private List<Consumables> consumables;

    @JoinTable(name = "TASK_PERSON_LINK",
            joinColumns = @JoinColumn(name = "TASK_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "PERSON_ID", referencedColumnName = "ID"))
    @ManyToMany
    @JsonProperty("persons")
    private List<Person> persons;


}
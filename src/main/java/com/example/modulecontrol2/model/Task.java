package com.example.modulecontrol2.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "task")
public class Task {
    public Task() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "outer_id")
    private String outerID;

    @Column
    private LocalDate date;


    @JoinColumn(name = "point_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Point point;

    @OneToMany(mappedBy = "task")
    private List<Person> perfomers;

    @OneToMany(mappedBy = "task")
    private List<Position> position;

    @ManyToOne(fetch = FetchType.LAZY)
    private Person client;

}

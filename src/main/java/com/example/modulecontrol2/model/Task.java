package com.example.modulecontrol2.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

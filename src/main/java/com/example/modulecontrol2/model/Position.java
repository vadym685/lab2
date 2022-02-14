package com.example.modulecontrol2.model;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "position")
public class Position {

    public Position() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "description")
    private String description ;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @OneToMany(mappedBy = "consumables")
    private List<Consumables> consumables;


}

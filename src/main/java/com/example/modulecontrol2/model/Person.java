package com.example.modulecontrol2.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "person")
public class Person {

    public Person() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "outer_id")
    private String outerID;

    @Column
    private String fullName;

    @Column
    private int phoneNumber;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @Column(name = "manager_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Person manager;

    @Column
    private UUID manager_id;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}

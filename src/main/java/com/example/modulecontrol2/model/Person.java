package com.example.modulecontrol2.model;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @JoinColumn(name = "manager_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Person manager;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}

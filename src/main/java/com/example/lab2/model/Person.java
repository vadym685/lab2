package com.example.lab2.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Person {
    @GeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "OUTER_ID")
    private String outerID;

    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @JoinColumn(name = "MANAGER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Person manager;

    @Column(name = "NAME")
    private String name;

    @JoinTable(name = "TASK_PERSON_LINK",
            joinColumns = @JoinColumn(name = "PERSON_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "TASK_ID", referencedColumnName = "ID"))
    @ManyToMany
    private List<Task> tasks;

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Person getManager() {
        return manager;
    }

    public void setManager(Person manager) {
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

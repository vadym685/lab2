package com.example.lab2.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    @Id
    private long id;

    @Column(name = "FULL_NAME")
    @JsonProperty("fullName")
    private String fullName;

    @Column(name = "PHONE_NUMBER")
    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @JoinColumn(name = "MANAGER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonProperty("manager")
    private Person manager;

    @Column(name = "NAME")
    @JsonProperty("name")
    private String name;

    @Column(name = "IS_MANAGER")
    @JsonProperty("isManager")
    private Boolean isManager;

    @JsonProperty("managerID")
    private String managerID;

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

    public long  getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Boolean isManager() {
        return isManager;
    }

    public String getManagerID() {
        return managerID;
    }

    public void setManagerID(String managerID) {
        this.managerID = managerID;
    }
}

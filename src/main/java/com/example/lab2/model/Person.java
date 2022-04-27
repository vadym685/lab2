package com.example.lab2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Person {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    @Id
    private long id;

    @Column(name = "NAME")
    @JsonProperty("name")
    private String name;

    @Column(name = "FULL_NAME")
    @JsonProperty("fullName")
    private String fullName;

    @Column(name = "PHONE_NUMBER")
    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @Column(name = "ADMIN")
    @JsonProperty("admin")
    private boolean admin;

    @JoinColumn(name = "MANAGER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonProperty("manager")
    private Person manager;

    @JsonProperty("managerID")
    private String managerID;

    @JoinTable(name = "TASK_PERSON_LINK",
            joinColumns = @JoinColumn(name = "PERSON_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "TASK_ID", referencedColumnName = "ID"))
    @ManyToMany
    private List<Task> tasks;

}

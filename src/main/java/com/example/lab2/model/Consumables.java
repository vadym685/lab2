package com.example.lab2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Table(name = "CONSUMABLES")
@Entity
@Data
public class Consumables {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    @Id
    private long  id;

    @Column(name = "DESCRIPTION")
    @JsonProperty("description")
    private String description;

    @Column(name = "NAME")
    @JsonProperty("name")
    private String name;

    @Column(name = "COMMENT")
    @JsonProperty("comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

}
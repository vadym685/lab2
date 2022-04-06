package com.example.lab2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Table(name = "POSITION")
@Entity
@Data
public class Position {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    @Id
    private long id;

    @Column(name = "DESCRIPTION")
    @JsonProperty("description")
    private String description;

    @Column(name = "COMMENT")
    @JsonProperty("comment")
    private String comment;

    @JoinColumn(name = "TASK_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Task task;

}
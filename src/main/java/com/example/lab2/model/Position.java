package com.example.lab2.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;


@Table(name = "POSITION")
@Entity
public class Position {
    @GeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;


    @Column(name = "DESCRIPTION")
    @JsonProperty("description")
    private String description;

    @Column(name = "COMMENT")
    @JsonProperty("comment")
    private String comment;

    @JoinTable(name = "POSITION_POSITION_LINK",
            joinColumns = @JoinColumn(name = "POSITION_1_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "POSITION_2_ID", referencedColumnName = "ID"))
    @ManyToMany
    @JsonProperty("consumables")
    private List<Position> consumables;

    @JoinColumn(name = "TASK_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Task task;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public List<Position> getConsumables() {
        return consumables;
    }

    public void setConsumables(List<Position> consumables) {
        this.consumables = consumables;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
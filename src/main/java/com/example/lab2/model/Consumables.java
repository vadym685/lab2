package com.example.lab2.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Table(name = "CONSUMABLES")
@Entity
public class Consumables {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    @Id
    private long  id;

    @Column(name = "DESCRIPTION")
    @JsonProperty("description")
    private String description;

    @Column(name = "COMMENT")
    @JsonProperty("comment")
    private String comment;

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

    public long  getId() {
        return id;
    }

    public void setId(long  id) {
        this.id = id;
    }
}
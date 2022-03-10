package com.example.lab2.model;

import javax.persistence.*;
import java.util.UUID;


@Table(name = "CONSUMABLES")
@Entity
public class Consumables {
    @GeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "COMMENT")
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
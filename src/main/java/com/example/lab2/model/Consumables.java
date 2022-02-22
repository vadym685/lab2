package com.example.lab2.model;

import javax.persistence.*;

@Entity
@Table(name = "consumables")
public class Consumables {

    public Consumables() {
    }

    @ManyToOne
    @JoinColumn(name = "consumables_id")
    private Position consumables;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "comment")
    private String comment;

    public Position getConsumables() {
        return consumables;
    }

    public void setConsumables(Position consumables) {
        this.consumables = consumables;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

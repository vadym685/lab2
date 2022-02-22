package com.example.lab2.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "position")
public class Position {

    public Position() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "comment")
    private String comment;

    @OneToMany(mappedBy = "consumables")
    private List<Consumables> consumables;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Task position;

    public Task getPosition() {
        return position;
    }

    public void setPosition(Task position) {
        this.position = position;
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

    public List<Consumables> getConsumables() {
        return consumables;
    }

    public void setConsumables(List<Consumables> consumables) {
        this.consumables = consumables;
    }
}

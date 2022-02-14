package com.example.modulecontrol2.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "questions")
public class Consumables {
    public Consumables() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "description")
    private String description;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "consumables_id")
    private Position consumables;

    public Position getConsumables() {
        return consumables;
    }

    public void setConsumables(Position consumables) {
        this.consumables = consumables;
    }
}

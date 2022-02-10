package com.example.modulecontrol2.model;

import javax.persistence.*;

@Entity
@Table(name = "questions")
public class Consumables {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description ;

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

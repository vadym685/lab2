package com.example.modulecontrol2.model;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "point")
public class Point {
    public Point() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "outer_id")
    private String outerID;

    @Column(name = "name")
    private String name;

    @Column(name = "adress")
    private String adress;

    @NumberFormat(pattern = "##,##0.00000")
    @Column(name = "latitude")
    protected Double latitude;

    @NumberFormat(pattern = "##,##0.00000")
    @Column(name = "longitude")
    protected Double longitude;

    @Column(name = "contactPerson")
    private String contactPerson;

    @Column(name = "contactNumber")
    private String contactNumber;

    @Column(name = "comment")
    private String comment;
}

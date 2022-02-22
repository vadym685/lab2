package com.example.modulecontrol2.model;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "person")
public class Person {

    public Person() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "outer_id")
    private String outerID;

    @Column
    private String fullName;

    @Column
    private int phoneNumber;

    @Column
    private String name;

    @Column
    private int manager_id;

    @OneToMany(mappedBy = "point")
    private List<Point> point;

    public String getOuterID() {
        return outerID;
    }

    public void setOuterID(String outerID) {
        this.outerID = outerID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Point> getPoint() {
        return point;
    }

    public void setPoint(List<Point> point) {
        this.point = point;
    }
}

package com.example.lab2.model;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "point")
public class Point {

    public Point() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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

    @ManyToOne
    @JoinColumn(name = "point_id")
    private Person point;

    @OneToMany(mappedBy = "task")
    private List<Task> task;

    public Person getPoint() {
        return point;
    }

    public void setPoint(Person point) {
        this.point = point;
    }

    public String getOuterID() {
        return outerID;
    }

    public void setOuterID(String outerID) {
        this.outerID = outerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<Task> getTask() {
        return task;
    }

    public void setTask(List<Task> task) {
        this.task = task;
    }
}

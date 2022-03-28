package com.example.lab2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;

@Table(name = "POINT")
@Entity
public class Point {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    @Id
    private long id;

    @Column(name = "NAME")
    @JsonProperty("name")
    private String name;

    @Column(name = "ADRESS")
    @JsonProperty("adress")
    private String adress;

    @NumberFormat(pattern = "##,##0.00000")
    @Column(name = "LATITUDE")
    @JsonProperty("latitude")
    private Double latitude;

    @NumberFormat(pattern = "##,##0.00000")
    @Column(name = "LONGITUDE")
    @JsonProperty("longitude")
    private Double longitude;

    @Column(name = "CONTACT_PERSON")
    @JsonProperty("contactPerson")
    private String contactPerson;

    @Column(name = "CONTACT_NUMBER")
    @JsonProperty("contactNumber")
    private String contactNumber;

    @Column(name = "COMMENT")
    @JsonProperty("comment")
    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long  getId() {
        return id;
    }

    public void setId(long  id) {
        this.id = id;
    }
}
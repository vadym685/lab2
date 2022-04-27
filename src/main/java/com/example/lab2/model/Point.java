package com.example.lab2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;

@Table(name = "POINT")
@Entity
@Data
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

}
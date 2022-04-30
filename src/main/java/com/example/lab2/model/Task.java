package com.example.lab2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "TASK", indexes = {
        @Index(name = "IDX_TASK_POINT_ID", columnList = "POINT_ID")
})
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Task {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    @Id
    private long id;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Column(name = "DATE")
    @JsonProperty("date")
    private Date date;

    @JoinColumn(name = "POINT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Point point;

    @JsonProperty("pointID")
    private String pointID;

    @OneToMany(mappedBy = "task")
    @JsonProperty("positions")
    @ToString.Exclude
    private List<Position> positions;

    @OneToMany(mappedBy = "task")
    @JsonProperty("consumables")
    @ToString.Exclude
    private List<Consumables> consumables;

    @JoinTable(name = "TASK_PERSON_LINK",
            joinColumns = @JoinColumn(name = "TASK_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "PERSON_ID", referencedColumnName = "ID"))
    @ManyToMany
    @JsonProperty("persons")
    @ToString.Exclude
    private List<Person> persons;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Task task = (Task) o;
        return true;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public long getPoint() {
        return point.getId();
    }

    public Point getPointObj() {
        return point;
    }
}
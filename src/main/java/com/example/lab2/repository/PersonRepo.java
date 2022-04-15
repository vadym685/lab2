package com.example.lab2.repository;

import com.example.lab2.model.Person;
import com.example.lab2.model.Point;
import com.example.lab2.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {
    public List<Person> findByName(String name);

    public List<Person> findByTasksIsContaining(Task task);

    public List<Person> findByAdmin(boolean admin);
}

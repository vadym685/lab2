package com.example.modulecontrol2.repo;

import com.example.modulecontrol2.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface UsersRepo extends JpaRepository<Users, Long> {
    List<Users> findByName(String name);
}

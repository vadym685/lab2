package com.example.modulecontrol2.service;


import com.example.modulecontrol2.model.Users;
import com.example.modulecontrol2.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private final UsersRepo usersRepo;

    public UsersService(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    public void createPerson(Users user) {
        usersRepo.save(user);
    }


    public List<Users> findAll(){
        return usersRepo.findAll();
    }

}

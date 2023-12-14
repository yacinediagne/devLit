package com.practice.devLit.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.practice.devLit.model.Users;
import com.practice.devLit.repository.UsersRepository;

@Controller
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping(value = "/users/{id}")
    public Optional<Users> getUser(int id) {
        return usersRepository.findById(id);
    }

}

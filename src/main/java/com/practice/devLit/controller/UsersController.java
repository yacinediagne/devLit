package com.practice.devLit.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.devLit.model.Users;
import com.practice.devLit.repository.UsersRepository;

@RestController
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping(value = "/users/{id}")
    public Optional<Users> getUser(Long id) {
        return usersRepository.findById(id);
    }

}

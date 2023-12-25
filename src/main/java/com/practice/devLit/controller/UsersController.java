package com.practice.devLit.controller;

import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.devLit.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.practice.devLit.model.Users;
import com.practice.devLit.repository.UsersRepository;

@RestController
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersService usersService;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping(value = "/users/{id}")
    public Optional<Users> getUser(@PathVariable Long id) {
        return usersRepository.findById(id);
    }

    @GetMapping(value = "/users")
    public Iterable<Users> getUsers() {
        return usersRepository.findAll();
    }

    @PostMapping("/user")
    public Users saveUser(@RequestBody String  user) throws JsonProcessingException {
        return usersService.saveUserByCapitalize(objectMapper.readValue(user,Users.class));
    }

    @DeleteMapping("/delete-user/{id}")
    public void deleteUser(@PathVariable Long id){
        usersRepository.deleteById(id);
    }

}

package com.practice.devLit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.devLit.model.Subjects;
import com.practice.devLit.repository.SubjectsRepository;

@RestController
public class SubjectsController {
    @Autowired
    private SubjectsRepository subjectsRepository;

    @GetMapping("/subjects")
    public Iterable<Subjects> getSubjects() {
        return subjectsRepository.findAll();
    }

}

package com.practice.devLit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.practice.devLit.model.Subjects;
import com.practice.devLit.repository.SubjectsRepository;

import javax.security.auth.Subject;
import java.util.Optional;

@RestController
public class SubjectsController {
    @Autowired
    private SubjectsRepository subjectsRepository;

    @GetMapping("/subjects")
    public Iterable<Subjects> getSubjects() {
        return subjectsRepository.findAll();
    }

    @GetMapping("/subject/{id}")
    public Optional<Subjects> getSubject(@PathVariable long id ) {
        return subjectsRepository.findById(id);
    }

    @PostMapping("/save-subject")
    public Subjects saveSubject(@RequestBody Subjects subjects){
        return subjectsRepository.save(subjects);
    }

}

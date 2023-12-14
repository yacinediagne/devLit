package com.practice.devLit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.devLit.model.Subjects;

@Repository
public interface SubjectsRepository extends CrudRepository<Subjects, Integer> {

}

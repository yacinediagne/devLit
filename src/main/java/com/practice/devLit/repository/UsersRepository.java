package com.practice.devLit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.devLit.model.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, Integer> {

}

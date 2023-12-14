package com.practice.devLit.repository;

import org.springframework.data.repository.CrudRepository;

import com.practice.devLit.model.Messages;

public interface MessagesRepository extends CrudRepository<Messages, Integer> {
    Iterable<Messages> findByPostId(int id);
}

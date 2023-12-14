package com.practice.devLit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.practice.devLit.model.Posts;

@Repository
public interface PostsRepository extends CrudRepository<Posts, Integer> {
    Iterable<Posts> findByAuthorId();

    Iterable<Posts> findSubjectId();

}
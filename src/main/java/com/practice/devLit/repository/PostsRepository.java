package com.practice.devLit.repository;

import javax.security.auth.Subject;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.practice.devLit.model.Posts;
import com.practice.devLit.model.Subjects;
import com.practice.devLit.model.Users;

@Repository
public interface PostsRepository extends CrudRepository<Posts, Long> {
    Iterable<Posts> findByAuthor(Users author);

    Iterable<Posts> findBySubject(Subjects subject);

}
package com.practice.devLit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.practice.devLit.model.Posts;
import com.practice.devLit.model.Subjects;

import java.util.List;
import java.util.Set;

@Repository
public interface PostsRepository extends CrudRepository<Posts, Long> {
    List<Posts> findByAuthorId(long authorId);

    List<Posts> findBySubjectInOrderByCreatedAtAsc(Set<Subjects> subjects);


}
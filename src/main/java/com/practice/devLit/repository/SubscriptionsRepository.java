package com.practice.devLit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.devLit.model.Subjects;
import com.practice.devLit.model.Subscriptions;
import com.practice.devLit.model.Users;

@Repository
public interface SubscriptionsRepository extends CrudRepository<Subscriptions, Long> {
    Iterable<Subscriptions> findBySubject(Subjects subject);

    Iterable<Subscriptions> findByUser(Users user);
}

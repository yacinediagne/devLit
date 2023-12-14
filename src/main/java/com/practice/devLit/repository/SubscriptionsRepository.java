package com.practice.devLit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.devLit.model.Subscriptions;

@Repository
public interface SubscriptionsRepository extends CrudRepository {
    Iterable<Subscriptions> findBySubject();

    Iterable<Subscriptions> findByUser();
}

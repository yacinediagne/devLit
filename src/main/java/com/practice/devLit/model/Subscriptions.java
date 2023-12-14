package com.practice.devLit.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "subscriptions")
public class Subscriptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany
    @JoinColumn(name = "id")
    private Subjects subjects;

    @OneToMany
    @JoinColumn(name = "id")
    private Users user;

}

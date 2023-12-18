package com.practice.devLit.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "subscriptions")
public class Subscriptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "subject_id", nullable = false)
    private Subjects subject;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "id", nullable = false)
    private Users user;

}

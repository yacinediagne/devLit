package com.practice.devLit.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "posts")
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "created_at")
    private String createdAt;

    private String description;

    private String title;

    @Column(name = "updated_at")
    private String updatedAt;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Users author;

    @OneToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subjects subject;

}

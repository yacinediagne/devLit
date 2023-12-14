package com.practice.devLit.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "messages")
public class Messages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String created_at;

    @Column
    private String message;

    @Column(name = "post_id")
    @JoinColumn(name = "posts", referencedColumnName = "id")
    private int postId;

    @Column(name = "author_id")
    @JoinColumn(name = "users", referencedColumnName = "id")
    private int authorId;
}
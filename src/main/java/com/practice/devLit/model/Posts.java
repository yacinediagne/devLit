package com.practice.devLit.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "posts")
//@NoArgsConstructor
@RequiredArgsConstructor
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "created_at")
    private LocalDate createdAt;

    private String description;

    private String title;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Users author;

    @OneToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subjects subject;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name= "post_id")
    List <Messages> listMessages ;

    public Posts(LocalDate createdAt, String description, String title, LocalDate updatedAt, Users author, Subjects subject) {
        this.createdAt = createdAt;
        this.description = description;
        this.title = title;
        this.updatedAt = updatedAt;
        this.author = author;
        this.subject = subject;
    }
    public Posts(LocalDate createdAt, String description, String title, LocalDate updatedAt, Users author, Subjects subject, List<Messages> listMessages) {
        this.createdAt = createdAt;
        this.description = description;
        this.title = title;
        this.updatedAt = updatedAt;
        this.author = author;
        this.subject = subject;
        this.listMessages = listMessages;
    }
}

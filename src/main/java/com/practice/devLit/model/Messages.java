package com.practice.devLit.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "messages")
@NoArgsConstructor
@AllArgsConstructor
public class Messages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private LocalDate created_at;

    @Column
    private String message;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "post_id", referencedColumnName = "id", nullable = false)
    private Posts post;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
    private Users user ;

    public Messages(LocalDate created_at, String message, Posts post, Users user) {
        this.created_at = created_at;
        this.message = message;
        this.post = post;
        this.user = user;
    }
}

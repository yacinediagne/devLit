package com.practice.devLit.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
//@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class Users {
//    public Users(boolean isAdmin, LocalDate createdAt, String email, String firstName, String lastName, String password, LocalDate updatedAt) {
//        this.isAdmin = isAdmin;
//        this.createdAt = createdAt;
//        this.email = email;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.password = password;
//        this.updatedAt = updatedAt;
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "admin")
    private boolean isAdmin;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String password;

    @Column(name = "updated_at")
    private LocalDate updatedAt;



}

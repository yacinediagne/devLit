package com.practice.devLit.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "subjects")
//@NoArgsConstructor
@RequiredArgsConstructor
public class Subjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private int subject_id;

    public Subjects(String description, String title) {
        this.description = description;
        this.title = title;
    }

    @Column
    private String description;

    @Column
    private String title;

}

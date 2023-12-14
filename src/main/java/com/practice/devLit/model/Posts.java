package com.practice.devLit.model;

@Data
@Entity
@Table(name = "posts")
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "created_at")
    private String createdAt;

    private String description;

    private String title;

    @Column(name = "updated_at")
    private String updatedAt;

    @ManytoOne
    @JoinColumn(name = "author_id")
    private Users user;

    @OnetoOne
    @JoinColumn(name = "subject_id")
    private Subjects subject;

}

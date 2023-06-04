package com.example.library.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "libs")
public class Librarian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "librarian_id")
    private Long librarianId;

    @Column(name = "first_name", length = 64)
    private String firstName;

    @Column(name = "last_name", length = 64)
    private String lastName;

    @OneToMany(mappedBy = "librarian")
    private List<SCard> sCards;

    @OneToMany(mappedBy = "librarian")
    private List<ECard> eCards;
}

package com.example.library.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "themes")
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "theme_id")
    private Long themeId;

    @Column(name = "name", length = 64)
    private String name;

    @OneToMany(mappedBy = "theme")
    private Set<Book> books;
}

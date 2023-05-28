package com.example.library.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "themes")
public class Theme {
    @Id
    @Column(name = "theme_id")
    private Long themeId;

    @Column(name = "name", length = 64)
    private String name;

    @OneToMany(mappedBy = "theme")
    private Set<Book> books;
}

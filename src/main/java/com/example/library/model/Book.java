package com.example.library.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "book_name", length = 64)
    private String bookName;

    @Column(name = "year", nullable = true)
    private int year;

    @Column(name = "pages", nullable = true)
    private int pages;

    @ManyToOne
    @JoinColumn(name = "theme_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Theme theme;

    @ManyToOne
    @JoinColumn(name = "press_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Press press;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Category category;

    @ManyToMany(mappedBy = "books")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Author> bookAuthors;
}

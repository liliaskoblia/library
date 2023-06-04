package com.example.library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long authorId;

    @NotBlank(message = "First Name must not be blank")
    @Column(name = "first_name", length = 64)
    private String firstName;

    @NotNull(message = "Please provide the Last Name")
    @Column(name = "last_name", length = 64)
    private String lastName;

    @ManyToMany
    @JoinTable(
            name = "books_authors",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    List<Book> books;

}

package com.example.library.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "press")
public class Press {
    @Id
    @Column(name = "press_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pressId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "press")
    private List<Book> books;
}

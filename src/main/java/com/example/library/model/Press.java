package com.example.library.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "press")
public class Press {
    @Id
    @Column(name = "press_id")
    private Long pressId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "press")
    private List<Book> books;
}

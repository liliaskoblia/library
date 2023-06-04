package com.example.library.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "e_cards")
public class ECard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "e_card_id")
    private Long eCardId;

    @OneToOne
    private Book book;

    @ManyToOne
    @JoinColumn(name = "librarian_id")
    private Librarian librarian;

    @OneToOne
    private Employee employee;

    @Column(name = "date_out")
    private LocalDateTime dateOut;

    @Column(name = "date_in")
    private LocalDateTime dateIn;
}

package com.example.library.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "e_cards")
public class ECard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

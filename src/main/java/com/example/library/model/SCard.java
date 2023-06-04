package com.example.library.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "s_cards")
public class SCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_card_id")
    private Long sCardId;

    @OneToOne
    private Book book;

    @ManyToOne
    @JoinColumn(name = "librarian_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Librarian librarian;

    @OneToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Student student;

    @Column(name = "date_out")
    private LocalDateTime dateOut;

    @Column(name = "date_in")
    private LocalDateTime dateIn;
}

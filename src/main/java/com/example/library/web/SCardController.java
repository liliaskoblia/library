package com.example.library.web;

import com.example.library.model.Book;
import com.example.library.model.Librarian;
import com.example.library.model.SCard;
import com.example.library.model.SCardDto;
import com.example.library.model.Student;
import com.example.library.repositories.BookRepository;
import com.example.library.repositories.LibrarianRepository;
import com.example.library.repositories.SCardRepository;
import com.example.library.repositories.StudentRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Slf4j
@Controller
@RequestMapping("/scard")
@RequiredArgsConstructor

public class SCardController {
    private final BookRepository bookRepo;
    private final LibrarianRepository librarianRepo;
    private final StudentRepository studentRepo;
    private final SCardRepository sCardRepo;


    @GetMapping
    public String showSCardForm() {
        return "scard";
    }

    @ModelAttribute(value = "scard")
    public SCardDto scard() {
        return new SCardDto();
    }

    @ModelAttribute(value = "allbooks")
    public Iterable<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @ModelAttribute(value = "allstudents")
    public Iterable<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @ModelAttribute(value = "librarians")
    public Iterable<Librarian> getAllLibrarians() {
        return librarianRepo.findAll();
    }

    @PostMapping
    public String processScard(@Valid @ModelAttribute(value = "scard") SCardDto scard, Errors errors) {
        if (errors.hasErrors()) {
            return "scard";
        }

        log.info("Processing scard: {}", scard);
        SCard sCardToSave = new SCard();
        sCardToSave.setBook(bookRepo.findById(scard.getBookId()).orElseThrow(NullPointerException::new));
        sCardToSave.setStudent(studentRepo.findById(scard.getStudentId()).orElseThrow(NullPointerException::new));
        sCardToSave.setLibrarian(librarianRepo.findById(scard.getLibrarianId()).orElseThrow(NullPointerException::new));
        sCardToSave.setDateOut(LocalDateTime.now());

        sCardRepo.save(sCardToSave);

        return "redirect:/scard";
    }
}

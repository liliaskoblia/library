package com.example.library.web;

import com.example.library.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepo;

    @GetMapping
    public String getAllBooks() {
        return "books";
    }

    @ModelAttribute
    public void allBooks(Model model) {
        var books = bookRepo.findAll();
        model.addAttribute("books", bookRepo.findAll());
    }
}

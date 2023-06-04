package com.example.library.web;

import com.example.library.model.Author;
import com.example.library.repositories.AuthorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorsController {
    private final AuthorRepository repo;

    @ModelAttribute(name = "authors")
    Iterable<Author> allAuthors() {
        return repo.findAll();
    }

    @GetMapping
    public String getAllAuthors() {
        return "authors";
    }
}

package com.example.library.web;

import com.example.library.model.Author;
import com.example.library.repositories.AuthorRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Slf4j
@Controller
@RequestMapping("/addauthor")
@SessionAttributes("author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorRepository repo;

    @GetMapping
    public String showAddAuthorForm() {
        return "addauthor";
    }

    @ModelAttribute
    public Author author() {
        return new Author();
    }

    @PostMapping
    public String processAuthor(@Valid Author author, Errors errors) {
        if (errors.hasErrors()) {
            return "addauthor";
        }

        log.info("Processing author: {}", author);
        repo.save(author);

        return "redirect:/";
    }
}

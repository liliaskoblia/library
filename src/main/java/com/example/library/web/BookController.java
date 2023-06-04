package com.example.library.web;

import com.example.library.model.Book;
import com.example.library.model.BooksByLetter;
import com.example.library.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookRepository repo;

    private final static List<String> ALPHABET = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");

    @GetMapping
    public String getAllBooks() {
        return "books";
    }

    @ModelAttribute
    public void setAlphabet(Model model) {
        model.addAttribute("booksByAlphabet", ALPHABET);
        List<BooksByLetter> booksByLetters = new ArrayList<>();
        var books = repo.findAll();
        for (var letter : ALPHABET) {
            var booksByLetter = filterByFirstLetter(books, letter);
            if (booksByLetter.isEmpty()) continue;
            booksByLetters.add(new BooksByLetter(letter, booksByLetter));
        }
        model.addAttribute("books", booksByLetters);

    }

    private String parseFirstLetterOfBookName(String name) {
        if (name.toUpperCase().startsWith("A ")) return name.substring(2, 3).toUpperCase();
        else if (name.toUpperCase().startsWith("THE ")) return name.substring(4, 5).toUpperCase();
        else return name.toUpperCase().substring(0, 1);
    }

    private List<Book> filterByFirstLetter(Iterable<Book> books, String firstLetter) {
        return StreamSupport.stream(books.spliterator(), false)
                .filter(book -> firstLetter.equals(parseFirstLetterOfBookName(book.getBookName())))
                .collect(Collectors.toList());
    }
}

package com.example.library.model;

public record BooksByLetter(String letter, Iterable<Book> books) {
}

package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/books")
    public List<Book> getAllNotes() {
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Optional<Book> getNoteById(@PathVariable(value = "id") Integer bookId) {
        return bookRepository.findById(bookId);
    }

    @GetMapping("/{genre}")
    public List<Book> findByGenre(@PathVariable(value = "genre") String genre) {
        return bookRepository.findByGenre(genre);
    }

}

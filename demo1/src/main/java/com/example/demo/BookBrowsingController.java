package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BookBrowsingController {

    @Autowired
    BookSortingRepository bookSortingRepository;

    @GetMapping("/books")
    public List<BookEntity> getAllNotes() {
        return bookSortingRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Optional<BookEntity> getNoteById(@PathVariable(value = "id") Integer bookId) {
        return bookSortingRepository.findById(bookId);
    }

    @GetMapping("/{genre}")
    public List<BookEntity> findByGenre(@PathVariable(value = "genre") String genre) {
        return bookSortingRepository.findByGenre(genre);
    }


    @GetMapping("/copies")
    public List<BookEntity> findByOrderByCopies() {
        return bookSortingRepository.findTop10ByOrderByCopiesDesc();
    }

}

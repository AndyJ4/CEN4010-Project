package com.bookstore.bookstoreapi.Controllers;

import com.bookstore.bookstoreapi.Entities.BookBrowsingEntity;
import com.bookstore.bookstoreapi.Repositories.BookBrowsingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BookBrowsingController {

        @Autowired
        BookBrowsingRepository bookBrowsingRepository;

        @GetMapping("/api/books")
        public List<BookBrowsingEntity> getAllNotes() {
            return bookBrowsingRepository.findAll();
        }

        @GetMapping("/api/books/{id}")
        public Optional<BookBrowsingEntity> getNoteById(@PathVariable(value = "id") Integer bookId) {
            return bookBrowsingRepository.findById(bookId);
        }

        @GetMapping("/api/{genre}")
        public List<BookBrowsingEntity> findByGenre(@PathVariable(value = "genre") String genre) {
            return bookBrowsingRepository.findByGenre(genre);
        }


        @GetMapping("/api/copies")
        public List<BookBrowsingEntity> findByOrderByCopies() {
            return bookBrowsingRepository.findTop10ByOrderByCopiesDesc();
        }
}

package com.bookstore.bookstoreapi.Controllers;

import com.bookstore.bookstoreapi.Entities.BookBrowsingEntity;
import com.bookstore.bookstoreapi.Repositories.BookBrowsingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.util.List;
import java.util.Map;
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

        @GetMapping("/api/books/genre/{genre}")
        public List<BookBrowsingEntity> findByGenre(@PathVariable(value = "genre") String genre) {
            return bookBrowsingRepository.findByGenre(genre);
        }

        @GetMapping("/api/books/copies")
        public List<BookBrowsingEntity> findByOrderByCopies() {
            return bookBrowsingRepository.findTop10ByOrderByCopiesDesc();
        }

        @GetMapping("api/books/rating/{rating}")
        public List<BookBrowsingEntity> findByRatingGreaterThan(@PathVariable(value = "rating") Double rating) {
            return bookBrowsingRepository.findByRatingGreaterThan(rating);
        }

}

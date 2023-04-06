package com.bookstore.bookstoreapi.Controllers;

import com.bookstore.bookstoreapi.Entities.BookBrowsingEntity;
import com.bookstore.bookstoreapi.Entities.User;
import com.bookstore.bookstoreapi.Repositories.BookBrowsingRepository;
import com.bookstore.bookstoreapi.Service.BookBrowsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
public class BookBrowsingController {
        @Autowired
        private BookBrowsingService service;

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

        @PostMapping(value = "api/books")
        public BookBrowsingEntity createBook(@RequestBody BookBrowsingEntity book) {
            return bookBrowsingRepository.save(book);
        }

        @PutMapping("/api/books/discount/{id}")
        public BookBrowsingEntity updateBook(@PathVariable Integer id, @RequestBody BookBrowsingEntity bookRequest) {
            return service.updateBook(id, bookRequest);
        }

        /*
        @PatchMapping("/api/books/patch/{id}")
        public BookBrowsingEntity updateBookFields(@PathVariable Integer id, @RequestBody Map<String, Object> fields) {
            return service.updateBookByFields(id, fields);
        }

        /*@PutMapping("/api/books/discount/{id}")
        public BookBrowsingEntity updateBook(@PathVariable Integer id, @RequestBody BookBrowsingEntity book) {
            BookBrowsingEntity bookToUpdate = bookBrowsingRepository.getReferenceById(id);
            bookToUpdate.setId(id);
            bookToUpdate.setPublisher(book.getPublisher());
            bookToUpdate.setName(book.getName());
            bookToUpdate.setGenre(book.getGenre());
            bookToUpdate.setCopies(book.getCopies());
            bookToUpdate.setRating(book.getRating());
            bookToUpdate.setPrice(book.getPrice());

            return bookBrowsingRepository.save(bookToUpdate);
        }*/


}

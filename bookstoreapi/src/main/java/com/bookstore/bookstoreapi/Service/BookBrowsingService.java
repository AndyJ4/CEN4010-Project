package com.bookstore.bookstoreapi.Service;

import com.bookstore.bookstoreapi.Entities.BookBrowsingEntity;
import com.bookstore.bookstoreapi.Repositories.BookBrowsingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookBrowsingService {
    @Autowired
    private BookBrowsingRepository repository;

    public BookBrowsingEntity updateBook(Integer id, BookBrowsingEntity bookRequest) {
        BookBrowsingEntity existingBook = repository.findById(id).get();
        existingBook.setPublisher(bookRequest.getPublisher());
        existingBook.setName(bookRequest.getName());
        existingBook.setGenre(bookRequest.getGenre());
        existingBook.setCopies(bookRequest.getCopies());
        existingBook.setRating(bookRequest.getRating());
        existingBook.setPrice(bookRequest.getPrice());
        return repository.save(existingBook);
    }
}

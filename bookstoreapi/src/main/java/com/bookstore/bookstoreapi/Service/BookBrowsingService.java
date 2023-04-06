package com.bookstore.bookstoreapi.Service;

import com.bookstore.bookstoreapi.Entities.BookBrowsingEntity;
import com.bookstore.bookstoreapi.Repositories.BookBrowsingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

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

    public BookBrowsingEntity updateBookByFields(Integer id, Map<String, Objects> fields) {
        Optional<BookBrowsingEntity> existingBook = repository.findById(id);

        if (existingBook.isPresent()) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(BookBrowsingEntity.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, existingBook.get(), value);
            });
            return repository.save(existingBook.get());
        }
        return null;
    }
}

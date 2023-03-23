package com.bookstore.bookstoreapi.Repositories;

import com.bookstore.bookstoreapi.Entities.BookBrowsingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookBrowsingRepository extends JpaRepository<BookBrowsingEntity, Integer> {
    List<BookBrowsingEntity> findByGenre(String genre);
    List<BookBrowsingEntity> findTop10ByOrderByCopiesDesc();
}

package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookSortingRepository extends JpaRepository<BookEntity, Integer> {
    List<BookEntity> findByGenre(String genre);
    List<BookEntity> findTop10ByOrderByCopiesDesc();
}

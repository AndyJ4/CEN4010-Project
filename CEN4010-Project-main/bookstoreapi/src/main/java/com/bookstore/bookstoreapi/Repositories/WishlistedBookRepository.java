package com.bookstore.bookstoreapi.Repositories;

import com.bookstore.bookstoreapi.Entities.WishlistedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistedBookRepository extends JpaRepository<WishlistedBook, Integer> {
    WishlistedBook getWishlistedBookByWishlistIdAndBookId(Integer wishlist_id, Integer book_id);
    List<WishlistedBook> getAllBywishlistId(Integer wishlist_id);
}

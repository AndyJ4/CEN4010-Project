package com.bookstore.bookstoreapi.Repositories;

import com.bookstore.bookstoreapi.Entities.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
    List<Wishlist> getAllByUserId(Integer userId);
}

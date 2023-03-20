package com.bookstore.bookstoreapi.Repositories;

import com.bookstore.bookstoreapi.Entities.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CreditRepository extends JpaRepository<Credit, Long> {
    @Query("SELECT u FROM Credit u WHERE " + "u.username LIKE CONCAT('%',:query, '%' )")
    List<Credit> searchCredits(String query);
}

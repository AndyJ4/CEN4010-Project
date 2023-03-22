package com.bookstore.bookstoreapi.Repositories;

import com.bookstore.bookstoreapi.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE " + "u.username LIKE CONCAT('%',:query, '%' )")
    List<User> searchUsers(String query);

    User getReferenceByUsername(String username);
}

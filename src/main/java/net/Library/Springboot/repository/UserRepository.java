package net.Library.Springboot.repository;


import net.Library.Springboot.entity.User1;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserRepository extends JpaRepository <User1, Long> {

    @Query("SELECT u FROM User1 u WHERE " + "u.username LIKE CONCAT('%',:query, '%' )")
    List<User1> searchUsers(String query);


}

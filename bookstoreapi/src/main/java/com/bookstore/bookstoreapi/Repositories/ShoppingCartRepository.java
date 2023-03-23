package com.bookstore.bookstoreapi.Repositories;

import com.bookstore.bookstoreapi.Entities.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,String> {


    List<ShoppingCart> findByUserid(String userid);
    List<ShoppingCart> findByISBN(Long ISBN);
}

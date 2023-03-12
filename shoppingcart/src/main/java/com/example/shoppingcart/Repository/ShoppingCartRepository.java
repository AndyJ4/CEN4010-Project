package com.example.shoppingcart.Repository;
import com.example.shoppingcart.Entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,String> {

    //@Query("SELECT p FROM ShoppingCart p")
    List<ShoppingCart> findByUserid(String userid);
    //@Query("SELECT p FROM ShoppingCart p")
    List<ShoppingCart> findByISBN(Long ISBN);
}

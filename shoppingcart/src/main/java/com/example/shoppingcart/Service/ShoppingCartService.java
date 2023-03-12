package com.example.shoppingcart.Service;

import com.example.shoppingcart.Entity.ShoppingCart;
import com.example.shoppingcart.Repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository rep;

    public List<ShoppingCart> findAll() {

        return rep.findAll();
    }

    public List<ShoppingCart> findByUserid(String userid) {

        return rep.findByUserid(userid);
    }


    public List<ShoppingCart> findByISBN(Long ISBN) {

        return rep.findByISBN(ISBN);
    }

    public ShoppingCart addBook(ShoppingCart shoppingCart) {

        return rep.save(shoppingCart);

    }

    public void delete(ShoppingCart shoppingCart){
        rep.delete(shoppingCart);
        System.out.println("book removed");
    }
}


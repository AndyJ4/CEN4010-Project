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

    public List<ShoppingCart> findByuserid(String userid){
        return rep.findByUserid(userid);
    }

    public List<ShoppingCart> findBybookid(Long bookid){
        return rep.findByBookid(bookid);
    }

    public void save(ShoppingCart shoppingCart){
        rep.save(shoppingCart);
    }

    public void delete(ShoppingCart shoppingCart){
        rep.save(shoppingCart);
    }
}

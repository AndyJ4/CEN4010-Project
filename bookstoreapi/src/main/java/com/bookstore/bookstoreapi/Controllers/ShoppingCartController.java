package com.bookstore.bookstoreapi.Controllers;

import com.bookstore.bookstoreapi.Service.ShoppingCartService;
import com.bookstore.bookstoreapi.Entities.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("shoppingcart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService service;

    @GetMapping("/userid")
    public List<ShoppingCart> findAll() {
        return service.findAll();
    }

    @GetMapping("/userid/{userid}")
    public List<ShoppingCart> findByUserid(@PathVariable(value = "userid") String userid) {
        return service.findByUserid(userid);
    }

    @GetMapping("/{ISBN}")
    public List<ShoppingCart> findByISBN(@PathVariable(value = "ISBN") Long ISBN) {
        return service.findByISBN(ISBN);
    }

    @PostMapping(value = "/add")
    public ShoppingCart addBook(@RequestBody ShoppingCart shoppingCart) {

        return service.addBook(shoppingCart);
    }

    @DeleteMapping(path =  "/delete/{list}")
    public void deleteBook(@RequestBody ShoppingCart shoppingCart){
        service.delete(shoppingCart);
    }

}

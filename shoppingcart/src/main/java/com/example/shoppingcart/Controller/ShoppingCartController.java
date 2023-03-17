package com.example.shoppingcart.Controller;

import com.example.shoppingcart.Entity.ShoppingCart;
import com.example.shoppingcart.Service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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


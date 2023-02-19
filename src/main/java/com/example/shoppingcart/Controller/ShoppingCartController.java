package com.example.shoppingcart.Controller;

import com.example.shoppingcart.Entity.ShoppingCart;
import com.example.shoppingcart.Service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("shoppingcart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService service;

    @GetMapping("/getuser")
    public List<ShoppingCart> findByUserid(Long userid) {
        return service.findBybookid(userid);
    }
    @GetMapping("/getid")
    public List<ShoppingCart> findByBookid(Long bookid) {
        return service.findBybookid(bookid);
    }
}

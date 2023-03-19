package com.bookstore.bookstoreapi.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping(value = "/api")
    public String getAPIString(){
        return "Welcome to Team 14's API!";
    }
}

package com.bookstore.bookstoreapi.Controllers;

import com.bookstore.bookstoreapi.Entities.Credit;
import com.bookstore.bookstoreapi.Repositories.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditController {


    @Autowired
    CreditRepository creditRepo;

    @PostMapping(value = "/api/credit")
    public Credit createCredit(@RequestBody Credit credit){
        return creditRepo.save(credit);
    }

}

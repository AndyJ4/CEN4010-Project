package net.Library.Springboot.controller;
import net.Library.Springboot.entity.Credit;
import java.util.List;

import net.Library.Springboot.entity.User1;
import net.Library.Springboot.service.CreditService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v2/credit")

public class CreditController {
    private CreditService creditService;
    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    @PostMapping
    public Credit createCredit(@RequestBody Credit credit){
        return creditService.createCredit(credit);
    }

}

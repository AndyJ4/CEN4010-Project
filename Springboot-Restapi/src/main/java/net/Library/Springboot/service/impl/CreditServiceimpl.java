package net.Library.Springboot.service.impl;

import net.Library.Springboot.repository.CreditRepository;
import net.Library.Springboot.entity.Credit;

import net.Library.Springboot.service.CreditService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class CreditServiceimpl implements CreditService {

    private CreditRepository creditRepository;

    public CreditServiceimpl(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }


    @Override
    public List<Credit> searchCredits(String query) {
        List<Credit> credits = creditRepository.searchCredits(query);
        return credits;
    }

    @Override
    public Credit createCredit(Credit credit) {
        return creditRepository.save(credit);
    }
}

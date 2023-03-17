package net.Library.Springboot.service;
import net.Library.Springboot.entity.Credit;
import net.Library.Springboot.entity.User1;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import java.util.List;
public interface CreditService {

    List<Credit> searchCredits(String query);
    Credit createCredit (Credit credit);
}

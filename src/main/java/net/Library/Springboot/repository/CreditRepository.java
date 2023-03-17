package net.Library.Springboot.repository;
import net.Library.Springboot.entity.Credit;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface CreditRepository extends JpaRepository <Credit, Long> {
    @Query("SELECT u FROM Credit u WHERE " + "u.username LIKE CONCAT('%',:query, '%' )")
    List<Credit> searchCredits(String query);
}

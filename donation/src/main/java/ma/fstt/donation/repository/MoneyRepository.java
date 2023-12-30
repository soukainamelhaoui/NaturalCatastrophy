package ma.fstt.donation.repository;

import ma.fstt.donation.model.Money;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoneyRepository extends JpaRepository<Money, Long> {
}

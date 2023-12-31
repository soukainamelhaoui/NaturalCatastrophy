package ma.fstt.donation.repository;

import ma.fstt.donation.model.Blood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodRepository extends JpaRepository<Blood, Long> {
}

package ma.fstt.donation.repository;

import ma.fstt.donation.model.Necessity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NecessityRepository extends JpaRepository<Necessity, Long> {
}

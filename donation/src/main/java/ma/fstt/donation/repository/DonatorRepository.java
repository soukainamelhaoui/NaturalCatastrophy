package ma.fstt.donation.repository;

import ma.fstt.donation.model.Donator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonatorRepository extends JpaRepository<Donator, Long> {
}
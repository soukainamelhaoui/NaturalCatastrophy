package ma.fstt.donation.repository;

import ma.fstt.donation.model.Donator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DonatorRepository extends JpaRepository<Donator, Long> {
    Donator findByUsername(String username);

    boolean existsByUsername(String username);
}

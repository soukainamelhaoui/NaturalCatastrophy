package ma.fstt.volunteering.repository;

import ma.fstt.volunteering.model.Necessity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NecessityRepository extends JpaRepository<Necessity, Long> {
}

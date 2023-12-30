package ma.fstt.volunteering.repository;

import ma.fstt.volunteering.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {
}

package ma.fstt.volunteering.repository;

import ma.fstt.volunteering.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {
    Volunteer findByUsername(String username);
    boolean existsByUsername(String username);
    List<Volunteer> findByIsVerifiedFalse();
    List<Volunteer> findAllByUsernameIn(List<String> usernames);
}

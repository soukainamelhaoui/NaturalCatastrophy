package ma.fstt.volunteering.repository;

import ma.fstt.volunteering.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}

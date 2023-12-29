package ma.fstt.volunteering.service;

import ma.fstt.volunteering.model.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle save(Vehicle vehicle);

    Vehicle update(Vehicle newVehicle, Long id);

    void delete(Long id);

    Vehicle getById(Long id);

    List<Vehicle> getAll();
}

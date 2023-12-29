package ma.fstt.volunteering.service;

import ma.fstt.volunteering.model.Vehicle;
import ma.fstt.volunteering.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImp implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public Vehicle save(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle update(Vehicle newVehicle, Long id) {
        return vehicleRepository.findById(id)
                .map(vehicle -> {
                    vehicle.setType(newVehicle.getType());
                    vehicle.setSize(newVehicle.getSize());
                    return vehicleRepository.save(vehicle);
                }).get();
    }

    @Override
    public void delete(Long id) {
        vehicleRepository.delete(this.getById(id));
    }

    @Override
    public Vehicle getById(Long id) {
        return vehicleRepository.findById(id).get();
    }

    @Override
    public List<Vehicle> getAll() {
        return vehicleRepository.findAll();
    }
}

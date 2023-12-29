package ma.fstt.volunteering.controller;

import ma.fstt.volunteering.model.Vehicle;
import ma.fstt.volunteering.service.VehicleService;
import ma.fstt.volunteering.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("/api/volunteering/vehicle")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @PostMapping("/save")
    public ResponseEntity<Vehicle> save(@RequestBody Vehicle vehicle){
        Vehicle savedVehicle = vehicleService.save(vehicle);
        return ResponseEntity.status(HttpStatus.OK).body(savedVehicle);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Vehicle> update(@RequestBody Vehicle vehicle, @PathVariable(value = "id") Long id){
        Vehicle newVehicle = vehicleService.update(vehicle, id);
        return ResponseEntity.status(HttpStatus.OK).body(newVehicle);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") Long id){
        vehicleService.delete(id);
        return "Deleted Successfully";
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Vehicle> getById(@PathVariable(value = "id") Long id){
        Vehicle vehicle = vehicleService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(vehicle);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Vehicle>> getAll(){
        List<Vehicle> vehicleList = vehicleService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(vehicleList);
    }



//    private final WebClient webClient;
//
//    public VehicleController(WebClient.Builder webClientBuilder) {
//        this.webClient = webClientBuilder.baseUrl("http://localhost:8222").build();
//    }
//
//    @GetMapping("/test")
//    public String test() {
//        String response = webClient
//                .get()
//                .uri("/api/donation/vehicle/all")
//                .retrieve()
//                .bodyToMono(String.class)
//                .block();
//
//        return "Response from donation microservice: " + response;
//    }

}

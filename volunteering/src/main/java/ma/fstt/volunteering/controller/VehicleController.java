package ma.fstt.volunteering.controller;

import ma.fstt.volunteering.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("/api/volunteering/vehicle")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;



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
//                .uri("/api/donation/necessity/all")
//                .retrieve()
//                .bodyToMono(String.class)
//                .block();
//
//        return "Response from donation microservice: " + response;
//    }

}

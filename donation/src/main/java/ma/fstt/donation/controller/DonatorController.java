package ma.fstt.donation.controller;

import ma.fstt.donation.model.Donator;
import ma.fstt.donation.service.DonatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/donator")
public class DonatorController {

    @Autowired
    DonatorService donatorService;

    @PostMapping("/save")
    public ResponseEntity<Donator> save(@RequestBody Donator donator){
        Donator savedDonator = donatorService.save(donator);
        return ResponseEntity.status(HttpStatus.OK).body(savedDonator);
    }

}

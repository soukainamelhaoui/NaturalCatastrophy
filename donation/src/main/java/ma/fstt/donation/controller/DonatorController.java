package ma.fstt.donation.controller;

import ma.fstt.donation.model.Donator;
import ma.fstt.donation.service.DonatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PutMapping("/update/{id}")
    public ResponseEntity<Donator> update(@RequestBody Donator donator, @PathVariable(value = "id") Long id){
        Donator newDonator = donatorService.update(donator, id);
        return ResponseEntity.status(HttpStatus.OK).body(newDonator);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") Long id){
        donatorService.delete(id);
        return "Deleted Successfully";
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Donator> getById(@PathVariable(value = "id") Long id){
        Donator donator = donatorService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(donator);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Donator>> getAll(){
        List<Donator> donatorList = donatorService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(donatorList);
    }

}

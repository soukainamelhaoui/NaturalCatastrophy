package ma.fstt.donation.controller;

import ma.fstt.donation.model.Necessity;
import ma.fstt.donation.service.NecessityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/necessity")
public class NecessityController {

    @Autowired
    NecessityService necessityService;

    @PostMapping("/save")
    public ResponseEntity<Necessity> save(@RequestBody Necessity necessity){
        Necessity savedNecessity = necessityService.save(necessity);
        return ResponseEntity.status(HttpStatus.OK).body(savedNecessity);
    }

}

package ma.fstt.donation.controller;

import ma.fstt.donation.model.Blood;
import ma.fstt.donation.service.BloodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/donation/blood")
public class BloodController {

    @Autowired
    BloodService bloodService;

    @PostMapping("/save")
    public ResponseEntity<Blood> save(@RequestBody Blood blood){
        Blood savedBlood = bloodService.save(blood);
        return ResponseEntity.status(HttpStatus.OK).body(savedBlood);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Blood> update(@RequestBody Blood blood, @PathVariable(value = "id") Long id){
        Blood newBlood = bloodService.update(blood, id);
        return ResponseEntity.status(HttpStatus.OK).body(newBlood);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, String> delete(@PathVariable(value = "id") Long id){
        bloodService.delete(id);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Deleted Successfully");
        return response;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Blood> getById(@PathVariable(value = "id") Long id){
        Blood blood = bloodService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(blood);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Blood>> getAll(){
        List<Blood> bloodList = bloodService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(bloodList);
    }
    
}

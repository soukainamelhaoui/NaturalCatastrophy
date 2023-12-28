package ma.fstt.volunteering.controller;

import ma.fstt.volunteering.model.Necessity;
import ma.fstt.volunteering.service.NecessityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/volunteering/necessity")
public class NecessityController {

    @Autowired
    NecessityService necessityService;

    @PostMapping("/save")
    public ResponseEntity<Necessity> save(@RequestBody Necessity necessity){
        Necessity savedNecessity = necessityService.save(necessity);
        return ResponseEntity.status(HttpStatus.OK).body(savedNecessity);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Necessity> update(@RequestBody Necessity necessity, @PathVariable(value = "id") Long id){
        Necessity newNecessity = necessityService.update(necessity, id);
        return ResponseEntity.status(HttpStatus.OK).body(newNecessity);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") Long id){
        necessityService.delete(id);
        return "Deleted Successfully";
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Necessity> getById(@PathVariable(value = "id") Long id){
        Necessity necessity = necessityService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(necessity);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Necessity>> getAll(){
        List<Necessity> necessityList = necessityService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(necessityList);
    }

}
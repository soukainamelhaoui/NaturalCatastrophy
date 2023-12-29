package ma.fstt.volunteering.controller;

import ma.fstt.volunteering.model.City;
import ma.fstt.volunteering.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/volunteering/city")
public class CityController {

    @Autowired
    CityService cityService;

    @PostMapping("/save")
    public ResponseEntity<City> save(@RequestBody City city){
        City savedCity = cityService.save(city);
        return ResponseEntity.status(HttpStatus.OK).body(savedCity);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<City> update(@RequestBody City city, @PathVariable(value = "id") Long id){
        City newCity = cityService.update(city, id);
        return ResponseEntity.status(HttpStatus.OK).body(newCity);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") Long id){
        cityService.delete(id);
        return "Deleted Successfully";
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<City> getById(@PathVariable(value = "id") Long id){
        City city = cityService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(city);
    }

    @GetMapping("/all")
    public ResponseEntity<List<City>> getAll(){
        List<City> cityList = cityService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(cityList);
    }
    
}

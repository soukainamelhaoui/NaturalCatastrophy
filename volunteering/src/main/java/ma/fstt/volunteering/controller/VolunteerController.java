package ma.fstt.volunteering.controller;

import ma.fstt.volunteering.model.Volunteer;
import ma.fstt.volunteering.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/volunteering/volunteer")
public class VolunteerController {

    @Autowired
    VolunteerService volunteerService;

    @PostMapping("/save")
    public ResponseEntity<Volunteer> save(@RequestBody Volunteer volunteer){
        Volunteer savedVolunteer = volunteerService.save(volunteer);
        return ResponseEntity.status(HttpStatus.OK).body(savedVolunteer);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Volunteer> update(@RequestBody Volunteer volunteer, @PathVariable(value = "id") Long id){
        Volunteer newVolunteer = volunteerService.update(volunteer, id);
        return ResponseEntity.status(HttpStatus.OK).body(newVolunteer);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") Long id){
        volunteerService.delete(id);
        return "Deleted Successfully";
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Volunteer> getById(@PathVariable(value = "id") Long id){
        Volunteer volunteer = volunteerService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(volunteer);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Volunteer>> getAll(){
        List<Volunteer> volunteerList = volunteerService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(volunteerList);
    }

    @GetMapping("/not-verified")
    public ResponseEntity<List<Volunteer>> findByIsVerifiedFalse(){
        List<Volunteer> volunteerList = volunteerService.findByIsVerifiedFalse();
        return ResponseEntity.status(HttpStatus.OK).body(volunteerList);
    }

    @PutMapping("/verify/{id}")
    public void verify(@PathVariable(value = "id") Long id){
        volunteerService.verify(id);
    }
    
}

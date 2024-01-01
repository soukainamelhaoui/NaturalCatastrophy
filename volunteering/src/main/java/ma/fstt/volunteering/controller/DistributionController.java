package ma.fstt.volunteering.controller;

import ma.fstt.volunteering.model.Distribution;
import ma.fstt.volunteering.service.DistributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/volunteering/distribution")
public class DistributionController {

    @Autowired
    DistributionService distributionService;

    @PostMapping("/save")
    public ResponseEntity<Distribution> save(@RequestBody Distribution distribution,
                                             @RequestParam List<Long> volunteerIds){
        Distribution savedDistribution = distributionService.save(distribution, volunteerIds);
        return ResponseEntity.status(HttpStatus.OK).body(savedDistribution);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Distribution> update(@RequestBody Distribution distribution, @PathVariable(value = "id") Long id){
        Distribution newDistribution = distributionService.update(distribution, id);
        return ResponseEntity.status(HttpStatus.OK).body(newDistribution);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") Long id){
        distributionService.delete(id);
        return "Deleted Successfully";
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Distribution> getById(@PathVariable(value = "id") Long id){
        Distribution distribution = distributionService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(distribution);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Distribution>> getAll(){
        List<Distribution> distributionList = distributionService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(distributionList);
    }

    @PutMapping("/{distributionId}/add-items")
    public ResponseEntity<Distribution> setItemIds(
            @PathVariable Long distributionId,
            @RequestBody List<Long> newItemIds) {
        Distribution updatedDistribution = distributionService.setItemIds(distributionId, newItemIds);
        return ResponseEntity.status(HttpStatus.OK).body(updatedDistribution);
    }


}

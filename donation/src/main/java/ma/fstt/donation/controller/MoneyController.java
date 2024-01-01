package ma.fstt.donation.controller;

import ma.fstt.donation.model.Money;
import ma.fstt.donation.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/donation/money")
public class MoneyController {

    @Autowired
    MoneyService moneyService;

    @PostMapping("/save")
    public ResponseEntity<Money> save(@RequestBody Money money){
        Money savedMoney = moneyService.save(money);
        return ResponseEntity.status(HttpStatus.OK).body(savedMoney);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Money> update(@RequestBody Money money, @PathVariable(value = "id") Long id){
        Money newMoney = moneyService.update(money, id);
        return ResponseEntity.status(HttpStatus.OK).body(newMoney);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, String> delete(@PathVariable(value = "id") Long id){
        moneyService.delete(id);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Deleted Successfully");
        return response;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Money> getById(@PathVariable(value = "id") Long id){
        Money money = moneyService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(money);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Money>> getAll(){
        List<Money> moneyList = moneyService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(moneyList);
    }

    @GetMapping("/total-money")
    public ResponseEntity<Float> getTotalMoney(){
        Float totalSum = moneyService.getTotalMoney();
        return ResponseEntity.status(HttpStatus.OK).body(totalSum);
    }
    
}

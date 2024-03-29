package ma.fstt.donation.controller;

import ma.fstt.donation.model.Item;
import ma.fstt.donation.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/donation/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping("/save")
    public ResponseEntity<Item> save(@RequestBody Item item){
        Item savedItem = itemService.save(item);
        return ResponseEntity.status(HttpStatus.OK).body(savedItem);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Item> update(@RequestBody Item item, @PathVariable(value = "id") Long id){
        Item newItem = itemService.update(item, id);
        return ResponseEntity.status(HttpStatus.OK).body(newItem);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, String> delete(@PathVariable(value = "id") Long id){
        itemService.delete(id);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Deleted Successfully");
        return response;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Item> getById(@PathVariable(value = "id") Long id){
        Item item = itemService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Item>> getAll(){
        List<Item> itemList = itemService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(itemList);
    }

    @PostMapping("/save-in-distribution")
    public List<String> selectItems(
            @RequestBody List<Long> itemIds) {
        return itemService.setItemsavailabilityToFalse(itemIds);
    }

}

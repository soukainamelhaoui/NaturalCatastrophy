package ma.fstt.donation.controller;

import ma.fstt.donation.model.Item;
import ma.fstt.donation.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping("/save")
    public ResponseEntity<Item> save(@RequestBody Item item){
        Item savedItem = itemService.save(item);
        return ResponseEntity.status(HttpStatus.OK).body(savedItem);
    }

}

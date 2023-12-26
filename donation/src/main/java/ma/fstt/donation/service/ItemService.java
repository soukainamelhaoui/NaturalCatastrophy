package ma.fstt.donation.service;

import ma.fstt.donation.model.Item;

import java.util.List;

public interface ItemService {
    Item save(Item item);

    Item update(Item item, Long id);

    void delete(Long id);

    Item getById(Long id);

    List<Item> getAll();
}

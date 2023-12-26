package ma.fstt.donation.service;

import ma.fstt.donation.model.Item;
import ma.fstt.donation.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImp implements ItemService{

    @Autowired
    ItemRepository itemRepository;

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item update(Item item, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Item getById(Long id) {
        return null;
    }

    @Override
    public List<Item> getAll() {
        return null;
    }
}

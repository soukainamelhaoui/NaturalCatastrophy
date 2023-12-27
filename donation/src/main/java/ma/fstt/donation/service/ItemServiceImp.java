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
    public Item update(Item newItem, Long id) {
        return itemRepository.findById(id)
                .map(item -> {
                    item.setDescription(newItem.getDescription());
                    item.setQuantity(newItem.getQuantity());
                    item.setDateOfDonation(newItem.getDateOfDonation());
                    item.setCityDonatedTo(newItem.getCityDonatedTo());
                    return itemRepository.save(item);
                }).get();
    }

    @Override
    public void delete(Long id) {
        itemRepository.delete(this.getById(id));
    }

    @Override
    public Item getById(Long id) {
        return itemRepository.findById(id).get();
    }

    @Override
    public List<Item> getAll() {
        return itemRepository.findAll();
    }
}

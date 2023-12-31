package ma.fstt.donation.service;

import ma.fstt.donation.model.Donator;
import ma.fstt.donation.model.Item;
import ma.fstt.donation.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImp implements ItemService{

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    private DonatorService donatorService;

    @Override
    public Item save(Item item) {

        String donatorUsername = item.getDonatorUsername();
        Donator donator = donatorService.findByUsername(donatorUsername);

        if (donator == null) {
            throw new RuntimeException("Donator not found with username: " + donatorUsername);
        }
        item.setDonator(donator);

        return itemRepository.save(item);
    }

    @Override
    public Item update(Item newItem, Long id) {
        return itemRepository.findById(id)
                .map(item -> {
                    item.setDescription(newItem.getDescription());
                    item.setQuantity(newItem.getQuantity());
                    item.setType(newItem.getType());
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
        return itemRepository.findByIsAvailableTrue();
    }

    public void setItemsavailabilityToFalse(List<Long> itemIds) {

        List<Item> items = itemRepository.findAllById(itemIds);
        for (Item item : items) {
            item.setIsAvailable(false);
        }
        itemRepository.saveAll(items);

    }

}

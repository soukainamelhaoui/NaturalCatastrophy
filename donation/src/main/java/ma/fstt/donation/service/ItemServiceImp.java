package ma.fstt.donation.service;

import ma.fstt.donation.model.Item;
import ma.fstt.donation.repository.DonatorRepository;
import ma.fstt.donation.repository.ItemRepository;
import ma.fstt.donation.util.LoggingFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class ItemServiceImp implements ItemService{

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    private DonatorRepository donatorRepository;

    @Override
    public Item save(Item item) {

//        Donator donator = item.getDonator();

//        // Check if the Donator is already in the database
//        if (donator != null && donator.getPhone() != null) {
//            Donator existingDonator = donatorRepository.findByPhone(donator.getPhone());
//            if (existingDonator != null) {
//                // Donator with the same phone number exists, use the existing one
//                item.setDonator(existingDonator);
//            } else {
//                // Donator with the same phone number doesn't exist, create a new one
//                donatorRepository.save(donator);
//                item.setDonator(donator);
//            }
//        } else {
//            // Donator is either null or phone number is not provided, create a new one
//            Donator newDonator = new Donator();
//            donatorRepository.save(newDonator);
//            item.setDonator(newDonator);
//        }

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

    @Value("${volunteering.url}")
    private String volunteeringUrl;

    @Autowired
    private WebClient.Builder webClientBuilder;


    public void sendItemsToDistribution(Long distributionId, List<Long> itemIds) {

        List<Item> items = itemRepository.findAllById(itemIds);
        for (Item item : items) {
            item.setIsAvailable(false);
        }
        itemRepository.saveAll(items);

        String url = "/distribution/{distributionId}/add-items";

        //add authentication later
        webClientBuilder.baseUrl(volunteeringUrl)
                .filter(new LoggingFilter())
                .build()
                .put()
                .uri(uriBuilder -> uriBuilder
                        .path(url)
                        .build(distributionId))
                .body(BodyInserters.fromValue(itemIds))
                .retrieve()
                .toBodilessEntity()
                .block();
    }

}

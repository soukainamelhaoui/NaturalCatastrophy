package ma.fstt.volunteering.service;

import ma.fstt.volunteering.config.LoggingFilter;
import ma.fstt.volunteering.model.City;
import ma.fstt.volunteering.model.Distribution;
import ma.fstt.volunteering.model.Volunteer;
import ma.fstt.volunteering.repository.CityRepository;
import ma.fstt.volunteering.repository.DistributionRepository;
import ma.fstt.volunteering.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DistributionServiceImp implements DistributionService {

    @Autowired
    DistributionRepository distributionRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    VolunteerRepository volunteerRepository;

    @Value("${donation.url}")
    private String donationUrl;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Override
    public Distribution save(Distribution distribution) {

        City city = cityRepository.findById(distribution.getCity().getId())
                .orElseThrow(() -> new RuntimeException("City with ID " + distribution.getCity().getId() + " not found"));
        distribution.setCity(city);

        List<Long> itemIds =  distribution.getItemIds();
        String url = "/item/save-in-distribution";
        webClientBuilder.baseUrl(donationUrl)
                .filter(new LoggingFilter())
                .build()
                .post()
                .uri(uriBuilder -> uriBuilder
                        .path(url)
                        .build())
                .body(BodyInserters.fromValue(itemIds))
                .retrieve()
                .toBodilessEntity()
                .block();

        return distributionRepository.save(distribution);
    }

    @Override
    public Distribution update(Distribution newDistribution, Long id) {
        return distributionRepository.findById(id)
                .map(distribution -> {
                    distribution.setDepartureDate(newDistribution.getDepartureDate());
                    distribution.setDepartureCity(newDistribution.getDepartureCity());
                    distribution.setVehicle(newDistribution.getVehicle());
                    return distributionRepository.save(distribution);
                }).get();
    }

    @Override
    public void delete(Long id) {
        distributionRepository.delete(this.getById(id));
    }

    @Override
    public Distribution getById(Long id) {
        return distributionRepository.findById(id).get();
    }

    @Override
    public List<Distribution> getAll() {
        return distributionRepository.findAll();
    }

    @Override
    public Distribution setItemIds(Long distributionId, List<Long> newItemIds) {
        Optional<Distribution> optionalDistribution = distributionRepository.findById(distributionId);
        if (optionalDistribution.isPresent()) {
            Distribution distribution = optionalDistribution.get();
            distribution.setItemIds(newItemIds);
            return distributionRepository.save(distribution);
        }
        return null;
    }

}

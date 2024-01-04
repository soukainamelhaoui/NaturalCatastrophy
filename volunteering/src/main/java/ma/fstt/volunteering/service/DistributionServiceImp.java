package ma.fstt.volunteering.service;

import ma.fstt.volunteering.config.LoggingFilter;
import ma.fstt.volunteering.model.Distribution;
import ma.fstt.volunteering.model.Volunteer;
import ma.fstt.volunteering.repository.DistributionRepository;
import ma.fstt.volunteering.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public class DistributionServiceImp implements DistributionService {

    @Autowired
    DistributionRepository distributionRepository;

    @Autowired
    VolunteerRepository volunteerRepository;

    @Value("${donation.url}")
    private String donationUrl;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Override
    public Distribution save(Distribution distribution, List<String> volunteerUsernames) {

        List<Volunteer> volunteers = volunteerRepository.findAllByUsernameIn(volunteerUsernames);
        distribution.setVolunteers(volunteers);

        List<Long> itemIds =  distribution.getItemIds();

        setItemNames(distribution, itemIds);
//        String url = "/item/save-in-distribution";
//        webClientBuilder.baseUrl(donationUrl)
//                .filter(new LoggingFilter())
//                .build()
//                .post()
//                .uri(uriBuilder -> uriBuilder
//                        .path(url)
//                        .build())
//                .body(BodyInserters.fromValue(itemIds))
//                .retrieve()
//                .toBodilessEntity()
//                .block();

        return distributionRepository.save(distribution);
    }

    @Override
    public Distribution update(Distribution newDistribution, Long id) {
        return distributionRepository.findById(id)
                .map(distribution -> {
                    distribution.setName(newDistribution.getName());
                    distribution.setDepartureDate(newDistribution.getDepartureDate());
                    distribution.setDepartureCity(newDistribution.getDepartureCity());
                    distribution.setVehicle(newDistribution.getVehicle());
                    distribution.setCity(newDistribution.getCity());
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

    @Override
    public void setItemNames(Distribution distribution, List<Long> itemIds) {

        String url = "/item/save-in-distribution";
        Mono<List<String>> itemNamesMono = webClientBuilder.baseUrl(donationUrl)
                .filter(new LoggingFilter())
                .build()
                .post()
                .uri(uriBuilder -> uriBuilder
                        .path(url)
                        .build())
                .body(BodyInserters.fromValue(itemIds))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<String>>() {});

        List<String> itemNames = itemNamesMono.block();

            distribution.setItemNames(itemNames);

            distributionRepository.save(distribution);

    }

    @Override
    public void setDistributionIsDoneToTrue(Long id){
        Distribution distribution = distributionRepository.findById(id).get();
        distribution.setIsDone(true);
        distributionRepository.save(distribution);
    }

    @Override
    public void setDistributionIsDoneToFalse(Long id){
        Distribution distribution = distributionRepository.findById(id).get();
        distribution.setIsDone(false);
        distributionRepository.save(distribution);
    }

}

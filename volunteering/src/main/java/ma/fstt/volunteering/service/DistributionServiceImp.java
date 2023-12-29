package ma.fstt.volunteering.service;

import ma.fstt.volunteering.model.Distribution;
import ma.fstt.volunteering.repository.DistributionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistributionServiceImp implements DistributionService {

    @Autowired
    DistributionRepository distributionRepository;

    @Override
    public Distribution save(Distribution distribution) {
        return distributionRepository.save(distribution);
    }

    @Override
    public Distribution update(Distribution newDistribution, Long id) {
        return distributionRepository.findById(id)
                .map(distribution -> {
                    distribution.setDepartureDate(newDistribution.getDepartureDate());
                    distribution.setDepartureCity(newDistribution.getDepartureCity());
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

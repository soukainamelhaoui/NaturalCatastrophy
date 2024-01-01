package ma.fstt.volunteering.service;

import ma.fstt.volunteering.model.Distribution;

import java.util.List;

public interface DistributionService {
    Distribution save(Distribution distribution, List<Long> volunteerIds);

    Distribution update(Distribution newDistribution, Long id);

    void delete(Long id);

    Distribution getById(Long id);

    List<Distribution> getAll();

    Distribution setItemIds(Long distributionId, List<Long> newItemIds);
}

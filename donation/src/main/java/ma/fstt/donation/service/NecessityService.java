package ma.fstt.donation.service;

import ma.fstt.donation.model.Necessity;

import java.util.List;

public interface NecessityService {
    Necessity save(Necessity necessity);

    Necessity update(Necessity necessity, Long id);

    void delete(Long id);

    Necessity getById(Long id);

    List<Necessity> getAll();
}

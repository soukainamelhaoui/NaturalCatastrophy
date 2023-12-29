package ma.fstt.volunteering.service;

import ma.fstt.volunteering.model.Necessity;

import java.util.List;

public interface NecessityService {
    Necessity save(Necessity necessity);

    Necessity update(Necessity newNecessity, Long id);

    void delete(Long id);

    Necessity getById(Long id);

    List<Necessity> getAll();
}
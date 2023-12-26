package ma.fstt.donation.service;

import ma.fstt.donation.model.Necessity;
import ma.fstt.donation.repository.NecessityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NecessityServiceImp implements NecessityService {

    @Autowired
    NecessityRepository necessityRepository;

    @Override
    public Necessity save(Necessity necessity) {
        return necessityRepository.save(necessity);
    }

    @Override
    public Necessity update(Necessity necessity, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Necessity getById(Long id) {
        return null;
    }

    @Override
    public List<Necessity> getAll() {
        return null;
    }
}

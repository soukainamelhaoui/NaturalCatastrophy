package ma.fstt.volunteering.service;

import ma.fstt.volunteering.model.Necessity;
import ma.fstt.volunteering.repository.NecessityRepository;
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
    public Necessity update(Necessity newNecessity, Long id) {
        return necessityRepository.findById(id)
                .map(necessity -> {
                    necessity.setDescription(newNecessity.getDescription());
                    necessity.setCity(newNecessity.getCity());
                    necessity.setQuantity(newNecessity.getQuantity());
                    return necessityRepository.save(necessity);
                }).get();
    }

    @Override
    public void delete(Long id) {
        necessityRepository.delete(this.getById(id));
    }

    @Override
    public Necessity getById(Long id) {
        return necessityRepository.findById(id).get();
    }

    @Override
    public List<Necessity> getAll() {
        return necessityRepository.findAll();
    }
}

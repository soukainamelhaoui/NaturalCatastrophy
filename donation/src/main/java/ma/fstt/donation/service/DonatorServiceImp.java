package ma.fstt.donation.service;

import ma.fstt.donation.model.Donator;
import ma.fstt.donation.repository.DonatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonatorServiceImp implements DonatorService {

    @Autowired
    DonatorRepository donatorRepository;

    @Override
    public Donator save(Donator donator) {
        return donatorRepository.save(donator);
    }

    @Override
    public Donator update(Donator donator, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Donator getById(Long id) {
        return null;
    }

    @Override
    public List<Donator> getAll() {
        return null;
    }
}

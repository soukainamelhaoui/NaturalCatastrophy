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

        if (donatorRepository.existsByUsername(donator.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        return donatorRepository.save(donator);
    }

    @Override
    public Donator update(Donator newDonator, Long id) {
        return donatorRepository.findById(id)
                .map(donator -> {
                    donator.setUsername(newDonator.getUsername());
                    donator.setFirstName(newDonator.getFirstName());
                    donator.setLastName(newDonator.getLastName());
                    donator.setAddress(newDonator.getAddress());
                    donator.setPhone(newDonator.getPhone());
                    return donatorRepository.save(donator);
                }).get();
    }

    @Override
    public void delete(Long id) {
        donatorRepository.delete(this.getById(id));
    }

    @Override
    public Donator getById(Long id) {
        return donatorRepository.findById(id).get();
    }

    @Override
    public List<Donator> getAll() {
        return donatorRepository.findAll();
    }

    public Donator findByUsername(String username) {
        return donatorRepository.findByUsername(username);
    }
}

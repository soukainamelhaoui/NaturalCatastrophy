package ma.fstt.donation.service;

import ma.fstt.donation.model.Donator;
import ma.fstt.donation.model.Blood;
import ma.fstt.donation.repository.BloodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodServiceImp implements BloodService {

    @Autowired
    BloodRepository bloodRepository;

    @Autowired
    private DonatorService donatorService;

    @Override
    public Blood save(Blood blood) {

        String donatorUsername = blood.getDonatorUsername();
        Donator donator = donatorService.findByUsername(donatorUsername);

        if (donator == null) {
            throw new RuntimeException("Donator not found with username: " + donatorUsername);
        }
        blood.setDonator(donator);

        return bloodRepository.save(blood);
    }

    @Override
    public Blood update(Blood newBlood, Long id) {
        return bloodRepository.findById(id)
                .map(blood -> {
                    blood.setBloodType(newBlood.getBloodType());
                    blood.setCity(newBlood.getCity());
                    blood.setAgency(newBlood.getAgency());
                    blood.setDonationDate(newBlood.getDonationDate());
                    blood.setLastDonationDate(newBlood.getLastDonationDate());
                    return bloodRepository.save(blood);
                }).get();
    }

    @Override
    public void delete(Long id) {
        bloodRepository.delete(this.getById(id));
    }

    @Override
    public Blood getById(Long id) {
        return bloodRepository.findById(id).get();
    }

    @Override
    public List<Blood> getAll() {
        return bloodRepository.findAll();
    }

}

package ma.fstt.donation.service;

import ma.fstt.donation.model.Donator;
import ma.fstt.donation.model.Money;
import ma.fstt.donation.repository.DonatorRepository;
import ma.fstt.donation.repository.MoneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoneyServiceImp implements MoneyService {
    
    @Autowired
    MoneyRepository moneyRepository;

    @Autowired
    private DonatorRepository donatorRepository;

    @Override
    public Money save(Money money) {

        Donator donator = money.getDonator();

        // Check if the Donator is already in the database
        if (donator != null && donator.getPhone() != null) {
            Donator existingDonator = donatorRepository.findByPhone(donator.getPhone());
            if (existingDonator != null) {
                // Donator with the same phone number exists, use the existing one
                money.setDonator(existingDonator);
            } else {
                // Donator with the same phone number doesn't exist, create a new one
                donatorRepository.save(donator);
                money.setDonator(donator);
            }
        }

        return moneyRepository.save(money);
    }

    @Override
    public Money update(Money newMoney, Long id) {
        return moneyRepository.findById(id)
                .map(money -> {
                    money.setAmount(newMoney.getAmount());
                    money.setDateOfDonation(newMoney.getDateOfDonation());
                    return moneyRepository.save(money);
                }).get();
    }

    @Override
    public void delete(Long id) {
        moneyRepository.delete(this.getById(id));
    }

    @Override
    public Money getById(Long id) {
        return moneyRepository.findById(id).get();
    }

    @Override
    public List<Money> getAll() {
        return moneyRepository.findAll();
    }
    
}

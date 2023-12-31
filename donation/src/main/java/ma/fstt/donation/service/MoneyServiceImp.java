package ma.fstt.donation.service;

import ma.fstt.donation.model.Donator;
import ma.fstt.donation.model.Money;
import ma.fstt.donation.repository.MoneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoneyServiceImp implements MoneyService {
    
    @Autowired
    MoneyRepository moneyRepository;

    @Autowired
    private DonatorService donatorService;

    @Override
    public Money save(Money money) {

        String donatorUsername = money.getDonatorUsername();
        Donator donator = donatorService.findByUsername(donatorUsername);

        if (donator == null) {
            throw new RuntimeException("Donator not found with username: " + donatorUsername);
        }
        money.setDonator(donator);

        return moneyRepository.save(money);
    }

    @Override
    public Money update(Money newMoney, Long id) {
        return moneyRepository.findById(id)
                .map(money -> {
                    money.setAmount(newMoney.getAmount());
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

    @Override
    public Float getTotalMoney() {
        List<Money> moneyList = getAll();

        Float totalSum = moneyList.stream()
                .map(Money::getAmount)
                .reduce(0.0f, Float::sum);

        return totalSum;
    }
    
}

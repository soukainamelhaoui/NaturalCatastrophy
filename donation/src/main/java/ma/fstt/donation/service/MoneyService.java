package ma.fstt.donation.service;

import ma.fstt.donation.model.Money;

import java.util.List;

public interface MoneyService {

    Money save(Money money);

    Money update(Money money, Long id);

    void delete(Long id);

    Money getById(Long id);

    List<Money> getAll();

    Float getTotalMoney();
    
}

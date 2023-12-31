package ma.fstt.donation.service;

import ma.fstt.donation.model.Blood;

import java.util.List;

public interface BloodService {

    Blood save(Blood blood);

    Blood update(Blood blood, Long id);

    void delete(Long id);

    Blood getById(Long id);

    List<Blood> getAll();
    
}

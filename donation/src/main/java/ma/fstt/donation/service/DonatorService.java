package ma.fstt.donation.service;

import ma.fstt.donation.model.Donator;

import java.util.List;

public interface DonatorService {
    Donator save(Donator donator);

    Donator update(Donator donator, Long id);

    void delete(Long id);

    Donator getById(Long id);

    List<Donator> getAll();

    Donator getByPhone(Long phone);
}

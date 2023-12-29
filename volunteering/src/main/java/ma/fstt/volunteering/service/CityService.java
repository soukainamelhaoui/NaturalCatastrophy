package ma.fstt.volunteering.service;

import ma.fstt.volunteering.model.City;

import java.util.List;

public interface CityService {
    City save(City city);

    City update(City newCity, Long id);

    void delete(Long id);

    City getById(Long id);

    List<City> getAll();
}

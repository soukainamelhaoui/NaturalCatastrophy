package ma.fstt.volunteering.service;

import ma.fstt.volunteering.model.City;
import ma.fstt.volunteering.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImp implements CityService {

    @Autowired
    CityRepository cityRepository;

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City update(City newCity, Long id) {
        return cityRepository.findById(id)
                .map(city -> {
                    city.setAddress(newCity.getAddress());
                    return cityRepository.save(city);
                }).get();
    }

    @Override
    public void delete(Long id) {
        cityRepository.delete(this.getById(id));
    }

    @Override
    public City getById(Long id) {
        return cityRepository.findById(id).get();
    }

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }
}

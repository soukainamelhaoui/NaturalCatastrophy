package ma.fstt.volunteering.service;

import ma.fstt.volunteering.model.Volunteer;
import ma.fstt.volunteering.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerServiceImp implements VolunteerService {

    @Autowired
    VolunteerRepository volunteerRepository;

    @Override
    public Volunteer save(Volunteer volunteer) {
        return volunteerRepository.save(volunteer);
    }

    @Override
    public Volunteer update(Volunteer newVolunteer, Long id) {
        return volunteerRepository.findById(id)
                .map(volunteer -> {
                    volunteer.setName(newVolunteer.getName());
                    volunteer.setAddress(newVolunteer.getAddress());
                    volunteer.setPhone(newVolunteer.getPhone());
                    return volunteerRepository.save(volunteer);
                }).get();
    }

    @Override
    public void delete(Long id) {
        volunteerRepository.delete(this.getById(id));
    }

    @Override
    public Volunteer getById(Long id) {
        return volunteerRepository.findById(id).get();
    }

    @Override
    public List<Volunteer> getAll() {
        return volunteerRepository.findAll();
    }
    
}

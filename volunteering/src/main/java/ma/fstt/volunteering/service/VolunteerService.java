package ma.fstt.volunteering.service;

import ma.fstt.volunteering.model.Volunteer;

import java.util.List;

public interface VolunteerService {

    Volunteer save(Volunteer volunteer);

    Volunteer update(Volunteer newVolunteer, Long id);

    void delete(Long id);

    Volunteer getById(Long id);

    List<Volunteer> getAll();

    Volunteer findByUsername(String username);

    void verify(Long id);

    void inverify(Long id);

    List<Volunteer> findByIsVerifiedFalse();
    
}

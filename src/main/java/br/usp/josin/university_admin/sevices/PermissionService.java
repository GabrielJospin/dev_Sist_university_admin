package br.usp.josin.university_admin.sevices;

import br.usp.josin.university_admin.entities.inter.Person;
import br.usp.josin.university_admin.entities.inter.Profile;
import br.usp.josin.university_admin.entities.inter.Service;
import br.usp.josin.university_admin.entities.intra.RelPersonProfile;
import br.usp.josin.university_admin.repository.PermissionRepository;
import br.usp.josin.university_admin.repository.PersonRepository;
import br.usp.josin.university_admin.repository.ProfileRepository;
import br.usp.josin.university_admin.repository.RelPersonProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Service
public class PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RelPersonProfileRepository relPersonProfileRepository;

    public Service hasPermission(Long idPerson, Character type, String entity){
        if(type != 'C' && type != 'R' && type != 'U' && type != 'D')
            return null;
        if(entity.length() != 3)
            return null;
        String filter = type + "_" + entity;
        List<Service> services = permissionRepository.findServiceByIdPersonAndFilter(idPerson, filter);
        if(services.isEmpty())
            return null;
        return services.get(0);
    }

    public RelPersonProfile addPersonProfile(Long personId, Long profileId, Date initDate, Date endDate ){

        Person person = personRepository.findPersonByIdPerson(personId);
        Profile profile = profileRepository.findProfileById(profileId);
        RelPersonProfile relPersonProfile = new RelPersonProfile(person, profile, initDate, endDate);
        return relPersonProfileRepository.save(relPersonProfile);
    }


    public RelPersonProfile updateProfile(RelPersonProfile relPersonProfile) {
        return relPersonProfileRepository.save(relPersonProfile);
    }

    public List<RelPersonProfile> getAllPermissions() {
        return relPersonProfileRepository.findAll();
    }
}

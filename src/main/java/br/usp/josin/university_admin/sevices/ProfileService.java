package br.usp.josin.university_admin.sevices;

import br.usp.josin.university_admin.entities.inter.Person;
import br.usp.josin.university_admin.entities.inter.Profile;
import br.usp.josin.university_admin.entities.intra.RelPersonProfile;
import br.usp.josin.university_admin.repository.ProfileRepository;
import br.usp.josin.university_admin.repository.RelPersonProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    RelPersonProfileRepository relPersonProfileRepository;

    public Profile findProfile(Long idProfile){
       return profileRepository.findProfileById(idProfile);
    }

    public Profile findProfile(String codeProfile){
        return profileRepository.findProfileByCode(codeProfile);
    }

    public RelPersonProfile addPersonProfile(Person person, Profile profile, Date initDate, Date endDate ){
        RelPersonProfile relPersonProfile = new RelPersonProfile(person, profile, initDate, endDate);
        return relPersonProfileRepository.save(relPersonProfile);
    }

}

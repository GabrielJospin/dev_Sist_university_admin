package br.usp.josin.university_admin.sevices;

import br.usp.josin.university_admin.entities.inter.Person;
import br.usp.josin.university_admin.entities.inter.Profile;
import br.usp.josin.university_admin.entities.intra.RelPersonProfile;
import br.usp.josin.university_admin.repository.PersonRepository;
import br.usp.josin.university_admin.repository.ProfileRepository;
import br.usp.josin.university_admin.repository.RelPersonProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    RelPersonProfileRepository relPersonProfileRepository;

    public Person getPerson(Long id){
        return personRepository.findPersonByIdPerson(id);
    }


    public Person createPerson(String nusp, String name, String document, String institution, String email, Timestamp birth) {
        Person person = new Person(nusp, name, document, institution, email, birth);
        Person out = personRepository.save(person);
        Profile profile = profileRepository.findProfileByCode("VISIT");
        System.out.println(profile.getIdProfile());
        RelPersonProfile relPersonProfile = null;
        try {
            relPersonProfile = new RelPersonProfile(out, profile, Date.from(Instant.now()), new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2138"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        relPersonProfileRepository.save(relPersonProfile);
        return out;
    }
}

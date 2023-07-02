package br.usp.josin.university_admin.sevices;

import br.usp.josin.university_admin.entities.inter.Person;
import br.usp.josin.university_admin.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public Person getPerson(Long id){
        return personRepository.findPersonByIdPerson(id);
    }


    public Person createPerson(String nusp, String name, String document, String institution, String email, Timestamp birth) {
        Person person = new Person(nusp, name, document, institution, email, birth);
        return personRepository.save(person);
    }
}

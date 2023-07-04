package br.usp.josin.university_admin.sevices;

import br.usp.josin.university_admin.entities.inter.Person;
import br.usp.josin.university_admin.entities.intra.SpecPerson;
import br.usp.josin.university_admin.repository.SpecilizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecializeService {

    @Autowired
    SpecilizeRepository specilizeRepository;

    public SpecPerson getSpecPersonByPerson(Person person){
        return specilizeRepository.findAllByPerson(person);
    }

    public SpecPerson updateSpecPerson(SpecPerson specPerson) {
        return specilizeRepository.save(specPerson);
    }
}

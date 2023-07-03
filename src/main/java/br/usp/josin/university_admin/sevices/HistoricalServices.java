package br.usp.josin.university_admin.sevices;

import br.usp.josin.university_admin.entities.inter.Person;
import br.usp.josin.university_admin.entities.intra.HistoricalUsage;
import br.usp.josin.university_admin.repository.HistoricalRepository;
import br.usp.josin.university_admin.repository.PermissionRepository;
import br.usp.josin.university_admin.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;

@Service
public class HistoricalServices {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PermissionRepository permissionRepository;

    @Autowired
    HistoricalRepository historicalRepository;

    public HistoricalUsage log(Long idPerson, Long idService){
        Person person = personRepository.findPersonByIdPerson(idPerson);
        br.usp.josin.university_admin.entities.inter.Service service = permissionRepository.findServiceByIdService(idService);
        HistoricalUsage historicalUsage = new HistoricalUsage(person, service, Timestamp.from(Instant.now()));
        return historicalRepository.save(historicalUsage);
    }
}

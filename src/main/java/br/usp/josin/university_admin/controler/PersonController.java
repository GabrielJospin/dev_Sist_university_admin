package br.usp.josin.university_admin.controler;

import br.usp.josin.university_admin.entities.inter.Person;
import br.usp.josin.university_admin.entities.inter.Service;
import br.usp.josin.university_admin.sevices.HistoricalServices;
import br.usp.josin.university_admin.sevices.PermissionService;
import br.usp.josin.university_admin.sevices.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private HistoricalServices historicalServices;


    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Long id){
        return personService.getPerson(id);
    }

    @GetMapping("/")
    public List<Person> getPersons(@RequestHeader Map<String, Object> headerData){
        Long personId = Long.valueOf( (String) headerData.get("person_id"));
        Service service = permissionService.hasPermission(personId, 'R', "PER");
        if ( service == null){
            return null;
        }

        List<Person> out = personService.getCourses();

        historicalServices.log(personId, service.getIdService());
        return out;

    }


    @PostMapping("/")
    public Person createPerson(@RequestBody Map<String, Object> userData){
        String nusp = (String) userData.get("nusp");
        String name = (String) userData.get("name");
        String document = (String) userData.get("document");
        String institution = (String) userData.get("institution");
        String email = (String) userData.get("email");
        Timestamp birth = Timestamp.valueOf((String) userData.get("birth"));

        return personService.createPerson(nusp, name, document, institution, email, birth);
    }
}

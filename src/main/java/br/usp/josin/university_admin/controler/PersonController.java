package br.usp.josin.university_admin.controler;

import br.usp.josin.university_admin.entities.inter.Person;
import br.usp.josin.university_admin.repository.PersonRepository;
import br.usp.josin.university_admin.sevices.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Map;

@RestController
@RequestMapping("/person/")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Long id){
        return personService.getPerson(id);
    }

    @PostMapping
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

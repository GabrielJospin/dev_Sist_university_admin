package br.usp.josin.university_admin.controler;

import br.usp.josin.university_admin.entities.inter.Person;
import br.usp.josin.university_admin.entities.inter.Professor;
import br.usp.josin.university_admin.entities.inter.Service;
import br.usp.josin.university_admin.entities.intra.SpecPerson;
import br.usp.josin.university_admin.sevices.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    PermissionService permissionService;

    @Autowired
    PersonService personService;

    @Autowired
    ProfessorService professorService;

    @Autowired
    SpecializeService specializeService;

    @Autowired
    HistoricalServices historicalServices;

    @PostMapping
    public Professor createProfessor(@RequestHeader Map<String, Object> headerData, @RequestBody Map<String, Object> bodyData){
        Long personId = Long.valueOf( (String) headerData.get("person_id"));
        Service service = permissionService.hasPermission(personId, 'C', "PRO");
        if ( service == null){
            return null;
        }

        Long idPerson = Long.valueOf((String) bodyData.get("id_person"));
        Person person = personService.getPerson(idPerson);

        String specialization = (String) bodyData.get("specialization");
        String levelOfStudent = (String) bodyData.get("level_of_education");
        String almaMatter = (String) bodyData.get("alma_matter");
        String institutionalWebsite = (String) bodyData.get("institutional_website");

        Professor professor = new Professor(specialization, levelOfStudent, almaMatter, institutionalWebsite);
        Professor out = professorService.createProfessor(professor);

        SpecPerson specPerson = specializeService.getSpecPersonByPerson(person);
        if(specPerson == null)
            specPerson = new SpecPerson();
        specPerson.setProfessor(out);
        specializeService.updateSpecPerson(specPerson);

        historicalServices.log(personId, service.getIdService());
        return out;
    }

    @GetMapping("/")
    public List<Professor> getProfessors(@RequestHeader Map<String, Object> headerData){
        Long personId = Long.valueOf( (String) headerData.get("person_id"));
        Service service = permissionService.hasPermission(personId, 'R', "PRO");
        if ( service == null){
            return null;
        }

        List<Professor> out = professorService.getProfessors();

        historicalServices.log(personId, service.getIdService());
        return out;
    }

    @PutMapping
    public Professor updateProfessor(@RequestHeader Map<String, Object> headerData, @RequestBody Professor professor){
        Long personId = Long.valueOf( (String) headerData.get("person_id"));
        Service service = permissionService.hasPermission(personId, 'U', "PRO");
        if ( service == null){
            return null;
        }

        Professor out = professorService.updateProfessor(professor);

        historicalServices.log(personId, service.getIdService());
        return out;
    }
}

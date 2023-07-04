package br.usp.josin.university_admin.controler;

import br.usp.josin.university_admin.entities.inter.Person;
import br.usp.josin.university_admin.entities.inter.Researcher;
import br.usp.josin.university_admin.entities.inter.Service;
import br.usp.josin.university_admin.entities.intra.SpecPerson;
import br.usp.josin.university_admin.sevices.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/researchers")
public class ResearcherController {

    @Autowired
    PermissionService permissionService;

    @Autowired
    PersonService personService;

    @Autowired
    ResearcherService researcherService;

    @Autowired
    SpecializeService specializeService;

    @Autowired
    HistoricalServices historicalServices;

    @PostMapping
    public Researcher createResearcher(@RequestHeader Map<String, Object> headerData, @RequestBody Map<String, Object> bodyData){
        Long personId = Long.valueOf( (String) headerData.get("person_id"));
        Service service = permissionService.hasPermission(personId, 'C', "RES");
        if ( service == null){
            return null;
        }

        Long idPerson = Long.valueOf((String) bodyData.get("id_person"));
        Person person = personService.getPerson(idPerson);

        String specialization = (String) headerData.get("specialization");
        Boolean isPostgraduateStudent = Boolean.getBoolean((String) bodyData.get("is_postgraduate_student"));

        Researcher researcher = new Researcher(specialization, isPostgraduateStudent);
        Researcher out = researcherService.createResearchet(researcher);

        SpecPerson specPerson = specializeService.getSpecPersonByPerson(person);
        specPerson.setResearcher(out);
        specializeService.updateSpecPerson(specPerson);

        historicalServices.log(personId, service.getIdService());
        return out;
    }

    @GetMapping
    public List<Researcher> getResearchers(@RequestHeader Map<String, Object> headerData){
        Long personId = Long.valueOf( (String) headerData.get("person_id"));
        Service service = permissionService.hasPermission(personId, 'R', "RES");
        if ( service == null){
            return null;
        }

        List<Researcher> out = researcherService.getResearchers();

        historicalServices.log(personId, service.getIdService());
        return out;
    }

    @PutMapping
    public Researcher updateResearcher(@RequestHeader Map<String, Object> headerData, @RequestBody Researcher researcher){
        Long personId = Long.valueOf( (String) headerData.get("person_id"));
        Service service = permissionService.hasPermission(personId, 'U', "RES");
        if ( service == null){
            return null;
        }

        Researcher out = researcherService.updateResearcher(researcher);

        historicalServices.log(personId, service.getIdService());
        return out;
    }
}

package br.usp.josin.university_admin.controler;

import br.usp.josin.university_admin.entities.inter.Employer;
import br.usp.josin.university_admin.entities.inter.Person;
import br.usp.josin.university_admin.entities.inter.Service;
import br.usp.josin.university_admin.entities.intra.SpecPerson;
import br.usp.josin.university_admin.sevices.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/employers")
public class EmployersController {

    @Autowired
    PermissionService permissionService;

    @Autowired
    PersonService personService;

    @Autowired
    EmployerService employerService;

    @Autowired
    SpecializeService specializeService;

    @Autowired
    HistoricalServices historicalServices;

    @PostMapping
    public Employer createEmployer(@RequestHeader Map<String, Object> headerData, @RequestBody Map<String, Object> bodyData){
        Long personId = Long.valueOf( (String) headerData.get("person_id"));
        Service service = permissionService.hasPermission(personId, 'C', "EMP");
        if ( service == null){
            return null;
        }

        Long idPerson = Long.valueOf((String) bodyData.get("id_person"));
        Person person = personService.getPerson(idPerson);

        String function = (String) headerData.get("function");
        int salary = Integer.parseInt((String) headerData.get("salary"));
        Employer employer = new Employer(function, salary);

        Employer out = employerService.createEmployer(employer);

        SpecPerson specPerson = specializeService.getSpecPersonByPerson(person);
        specPerson.setEmployer(out);
        specializeService.updateSpecPerson(specPerson);

        historicalServices.log(personId, service.getIdService());
        return out;
    }

    @GetMapping
    public List<Employer> getEmployers(@RequestHeader Map<String, Object> headerData){
        Long personId = Long.valueOf( (String) headerData.get("person_id"));
        Service service = permissionService.hasPermission(personId, 'R', "EMP");
        if ( service == null){
            return null;
        }

        List<Employer> out = employerService.getEmployers();

        historicalServices.log(personId, service.getIdService());
        return out;
    }

    @PutMapping
    public Employer updateEmployer(@RequestHeader Map<String, Object> headerData, @RequestBody Employer employer){
        Long personId = Long.valueOf( (String) headerData.get("person_id"));
        Service service = permissionService.hasPermission(personId, 'U', "EMP");
        if ( service == null){
            return null;
        }

        Employer out = employerService.updateEmployer(employer);

        historicalServices.log(personId, service.getIdService());
        return out;
    }

}

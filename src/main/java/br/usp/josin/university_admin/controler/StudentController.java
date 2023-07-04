package br.usp.josin.university_admin.controler;

import br.usp.josin.university_admin.entities.inter.Person;
import br.usp.josin.university_admin.entities.inter.Service;
import br.usp.josin.university_admin.entities.inter.Student;
import br.usp.josin.university_admin.entities.intra.SpecPerson;
import br.usp.josin.university_admin.sevices.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    PermissionService permissionService;

    @Autowired
    StudentService studentService;

    @Autowired
    HistoricalServices historicalServices;

    @Autowired
    PersonService personService;

    @Autowired
    SpecializeService specializeService;

    @PostMapping
    public Student createStudent(@RequestHeader Map<String, Object> headerData, @RequestBody Map<String, Object> bodyData){
        Long personId = Long.valueOf( (String) headerData.get("person_id"));
        Service service = permissionService.hasPermission(personId, 'C', "STU");
        if ( service == null){
            return null;
        }

        Long idPerson = Long.valueOf((String) bodyData.get("id_person"));
        Person person = personService.getPerson(idPerson);

        String course = (String) bodyData.get("course");
        double entryGrade = Double.parseDouble((String) bodyData.get("entry_grade"));


        Student student = new Student(course, entryGrade);

        Student out = studentService.createStudent(student);

        SpecPerson specPerson = specializeService.getSpecPersonByPerson(person);
        specPerson.setStudent(student);
        specializeService.updateSpecPerson(specPerson);

        historicalServices.log(personId, service.getIdService());
        return out;
    }

    @GetMapping
    public List<Student> getStudents(@RequestHeader Map<String, Object> headerData){
        Long personId = Long.valueOf( (String) headerData.get("person_id"));
        Service service = permissionService.hasPermission(personId, 'U', "STU");
        if ( service == null){
            return null;
        }

        List<Student> out = studentService.getStudents();

        historicalServices.log(personId, service.getIdService());
        return out;
    }

    @PutMapping
    public Student updateStudent(@RequestHeader Map<String, Object> headerData, @RequestBody Student student){
        Long personId = Long.valueOf( (String) headerData.get("person_id"));
        Service service = permissionService.hasPermission(personId, 'R', "STU");
        if ( service == null){
            return null;
        }

        Student out = studentService.updateStudent(student);

        historicalServices.log(personId, service.getIdService());
        return out;
    }
}

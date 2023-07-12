package br.usp.josin.university_admin.controler;

import br.usp.josin.university_admin.entities.inter.Course;
import br.usp.josin.university_admin.entities.inter.Service;
import br.usp.josin.university_admin.sevices.CourseService;
import br.usp.josin.university_admin.sevices.HistoricalServices;
import br.usp.josin.university_admin.sevices.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    PermissionService permissionService;

    @Autowired
    CourseService courseService;

    @Autowired
    HistoricalServices historicalServices;

    @PostMapping
    public Course createCourse(@RequestHeader Map<String, Object> headerData, @RequestBody Map<String, Object> bodyData){
        Long personId = Long.valueOf( (String) headerData.get("person_id"));
        Service service = permissionService.hasPermission(personId, 'C', "CUR");
        if ( service == null){
            return null;
        }

        String codeCourse = (String) bodyData.get("cod_Course");
        String name = (String)  bodyData.get("name");
        String description = (String) bodyData.get("description");
        String menu = (String) bodyData.get("menu");
        String institution = (String) bodyData.get("institution");
        Date creation = Timestamp.valueOf( bodyData.get("creation") + " 00:00:00");

        Course course = new Course(codeCourse, name, description, menu, institution, creation);

        Course out = courseService.createCourse(course);

        historicalServices.log(personId, service.getIdService());
        return out;
    }

    @GetMapping
    public List<Course> getCourses(@RequestHeader Map<String, Object> headerData){

        Long personId = Long.valueOf( (String) headerData.get("person_id"));
        Service service = permissionService.hasPermission(personId, 'R', "CUR");
        if ( service == null){
            return null;
        }

        List<Course> out = courseService.getCourses();

        historicalServices.log(personId, service.getIdService());
        return out;

    }

    @PutMapping
    public Course updateCourse(@RequestHeader Map<String, Object> headerData, @RequestBody Course course){
        Long personId = Long.valueOf( (String) headerData.get("person_id"));
        Service service = permissionService.hasPermission(personId, 'U', "CUR");
        if ( service == null){
            return null;
        }

        Course out = courseService.createCourse(course);

        historicalServices.log(personId, service.getIdService());
        return out;

    }



}

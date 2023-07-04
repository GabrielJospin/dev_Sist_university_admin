package br.usp.josin.university_admin.sevices;

import br.usp.josin.university_admin.entities.inter.Course;
import br.usp.josin.university_admin.entities.inter.Professor;
import br.usp.josin.university_admin.entities.inter.Student;
import br.usp.josin.university_admin.entities.intra.Offering;
import br.usp.josin.university_admin.repository.OfferingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OfferingService {

    @Autowired
    OfferingRepository offeringRepository;

    @Autowired
    StudentService studentService;

    @Autowired
    ProfessorService professorService;

    @Autowired
    CourseService courseService;

    public Offering createOffering(Long idStudent, Long idProfessor, Long idCourse, Date initDate, Date endDate, Double grade, String classroom, String institution) {
        Student student = studentService.getStudent(idStudent);
        Professor professor = professorService.getProfessor(idProfessor);
        Course course = courseService.getCourse(idCourse);
        Offering offering = new Offering(student, professor, course, initDate, endDate, grade, classroom, institution);
        return offeringRepository.save(offering);
    }

    public List<Offering> getOfferings() {
        return offeringRepository.findAll();
    }

    public Offering createOffering(Offering offering) {
        return offeringRepository.save(offering);
    }
}

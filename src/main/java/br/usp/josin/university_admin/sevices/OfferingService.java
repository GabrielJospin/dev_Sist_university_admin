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


    public Offering createOffering(Student student, Professor professor, Course course, Date initDate, Date endDate, Double grade, String classroom, String institution) {
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

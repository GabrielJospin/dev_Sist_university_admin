package br.usp.josin.university_admin.sevices;

import br.usp.josin.university_admin.entities.inter.Employer;
import br.usp.josin.university_admin.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerService {

    @Autowired
    EmployerRepository employerRepository;

    public Employer createEmployer(Employer employer) {
        return employerRepository.save(employer);
    }

    public List<Employer> getEmployers() {
        return employerRepository.findAll();
    }

    public Employer updateEmployer(Employer employer) {
        return employerRepository.save(employer);
    }
}

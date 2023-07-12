package br.usp.josin.university_admin.sevices;

import br.usp.josin.university_admin.entities.inter.Professor;
import br.usp.josin.university_admin.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository professorRepository;


    public Professor createProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public List<Professor> getProfessors() {
        return professorRepository.findAll();
    }

    public Professor updateProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public Professor getProfessor(Long idProfessor) {
        return professorRepository.getById(idProfessor);
    }
}

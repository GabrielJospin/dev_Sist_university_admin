package br.usp.josin.university_admin.sevices;

import br.usp.josin.university_admin.entities.inter.Researcher;
import br.usp.josin.university_admin.repository.ResearcherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResearcherService {

    @Autowired
    ResearcherRepository researcherRepository;

    public Researcher createResearchet(Researcher researcher) {
        return researcherRepository.save(researcher);
    }

    public List<Researcher> getResearchers() {
        return researcherRepository.findAll();
    }

    public Researcher updateResearcher(Researcher researcher) {
        return researcherRepository.save(researcher);
    }
}

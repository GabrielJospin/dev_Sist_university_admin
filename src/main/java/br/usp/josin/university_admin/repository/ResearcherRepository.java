package br.usp.josin.university_admin.repository;

import br.usp.josin.university_admin.entities.inter.Researcher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResearcherRepository extends JpaRepository<Researcher, Long> {
}

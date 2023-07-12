package br.usp.josin.university_admin.repository;

import br.usp.josin.university_admin.entities.inter.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}

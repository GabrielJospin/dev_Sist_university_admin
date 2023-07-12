package br.usp.josin.university_admin.repository;

import br.usp.josin.university_admin.entities.inter.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer, Long> {
}

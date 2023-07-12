package br.usp.josin.university_admin.repository;

import br.usp.josin.university_admin.entities.inter.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

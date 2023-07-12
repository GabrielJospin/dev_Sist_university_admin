package br.usp.josin.university_admin.repository;

import br.usp.josin.university_admin.entities.inter.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}

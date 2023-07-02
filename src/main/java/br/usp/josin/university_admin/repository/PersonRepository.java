package br.usp.josin.university_admin.repository;

import br.usp.josin.university_admin.entities.inter.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findPersonByIdPerson(Long id);
}

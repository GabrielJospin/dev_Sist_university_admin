package br.usp.josin.university_admin.repository;

import br.usp.josin.university_admin.entities.inter.Person;
import br.usp.josin.university_admin.entities.intra.SpecPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecilizeRepository extends JpaRepository<SpecPerson, Long> {

    SpecPerson findAllByPerson(Person person);

}

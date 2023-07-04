package br.usp.josin.university_admin.repository;

import br.usp.josin.university_admin.entities.intra.Offering;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferingRepository extends JpaRepository<Offering, Long> {
}

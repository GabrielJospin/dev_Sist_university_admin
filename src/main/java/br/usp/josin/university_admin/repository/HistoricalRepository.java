package br.usp.josin.university_admin.repository;

import br.usp.josin.university_admin.entities.intra.HistoricalUsage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricalRepository extends JpaRepository<HistoricalUsage, Long> {

}

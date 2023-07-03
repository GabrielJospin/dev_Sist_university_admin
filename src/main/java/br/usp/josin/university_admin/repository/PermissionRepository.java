package br.usp.josin.university_admin.repository;

import br.usp.josin.university_admin.entities.inter.Service;
import com.sun.tools.javac.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PermissionRepository extends JpaRepository<Service, Long> {


    @Query("select s from Service s join Profile p join RelPersonProfile rsp where rsp.person.idPerson = :idPerson and s.codeService like :filter")
    List<Service> findServiceByIdPersonAndFilter(Long idPerson, String filter);
}

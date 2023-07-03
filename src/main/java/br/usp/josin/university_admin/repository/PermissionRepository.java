package br.usp.josin.university_admin.repository;

import br.usp.josin.university_admin.entities.inter.Service;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PermissionRepository extends JpaRepository<Service, Long> {


    @Query(value="select s.* from university_admin.production.rel_person_profile rpp " +
            "left join university_admin.production.services s on s.id_profile = rpp.id_profile" +
            " where rpp.id_person = :idPerson and s.code_service like concat('%', :filter)", nativeQuery = true)
    List<Service> findServiceByIdPersonAndFilter(Long idPerson, String filter);
}

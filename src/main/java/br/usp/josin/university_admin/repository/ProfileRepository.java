package br.usp.josin.university_admin.repository;

import br.usp.josin.university_admin.entities.inter.Profile;
import br.usp.josin.university_admin.entities.intra.RelPersonProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    @Query("select p from Profile p where p.idProfile =:idProfile")
    Profile findProfileById(Long idProfile);

    @Query("select p from Profile p where p.codProfile =:codeProfile")
    Profile findProfileByCode(String codeProfile);
}

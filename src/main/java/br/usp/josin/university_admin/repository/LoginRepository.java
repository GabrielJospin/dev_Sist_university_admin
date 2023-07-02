package br.usp.josin.university_admin.repository;

import br.usp.josin.university_admin.entities.inter.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoginRepository  extends JpaRepository<Login, Long> {

    @Query(
            "select l from Login l where l.login =:login and l.password = md5(:pass)"
    )
    Login findLoginByAuth(String login, String pass);

}

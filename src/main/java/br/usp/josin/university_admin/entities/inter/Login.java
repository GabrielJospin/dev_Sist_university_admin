package br.usp.josin.university_admin.entities.inter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "login", schema = "production")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Login")
    private Long idLogin;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @OneToOne
    @JoinColumn(name = "id_person", referencedColumnName = "id_person")
    private Person person;

    public Login() {
    }

    public Login(Long idLogin, String login, String password, Person person) {
        this.idLogin = idLogin;
        this.login = login;
        this.password = password;
        this.person = person;
    }

    public Login(Long idLogin, String login, Person person) {
        this.idLogin = idLogin;
        this.login = login;
        this.person = person;
    }

    public Login(String login, String password, Person person) {
        this.login = login;
        this.password = password;
        this.person = person;
    }

    public Long getIdLogin() {
        return idLogin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Login)) return false;
        Login login1 = (Login) o;
        return Objects.equals(idLogin, login1.idLogin) &&
                Objects.equals(login, login1.login) &&
                Objects.equals(password, login1.password) &&
                Objects.equals(person, login1.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLogin, login, password, person);
    }
}

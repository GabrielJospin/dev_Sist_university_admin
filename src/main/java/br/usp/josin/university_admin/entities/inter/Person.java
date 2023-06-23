package br.usp.josin.university_admin.entities.inter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Embeddable
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person")
    private Long idPerson;

    @Column(name = "nusp")
    private String nusp;

    @Column(name = "name")
    private String name;

    @Column(name = "document")
    private String document;

    @Column(name = "institution")
    private  String institution;

    @Column (name = "email")
    private String email;

    @Column(name = "birth")
    private Date birth;

    public Person(String nusp, String name, String document, String institution, String email, Date birth) {
        this.nusp = nusp;
        this.name = name;
        this.document = document;
        this.institution = institution;
        this.email = email;
        this.birth = birth;
    }

    public Person(Long idPerson, String nusp, String name, String document, String institution, String email, Date birth) {
        this.idPerson = idPerson;
        this.nusp = nusp;
        this.name = name;
        this.document = document;
        this.institution = institution;
        this.email = email;
        this.birth = birth;
    }

    public Person() {
    }

    public Long getId() {
        return this.idPerson;
    }

    public String getNusp() {
        return nusp;
    }

    public void setNusp(String nusp) {
        this.nusp = nusp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(idPerson, person.idPerson) &&
                Objects.equals(nusp, person.nusp) &&
                Objects.equals(name, person.name) &&
                Objects.equals(document, person.document) &&
                Objects.equals(institution, person.institution) &&
                Objects.equals(email, person.email) &&
                Objects.equals(birth, person.birth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPerson, nusp, name, document, institution, email, birth);
    }
}

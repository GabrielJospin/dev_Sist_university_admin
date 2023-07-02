package br.usp.josin.university_admin.entities.inter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "professor", schema = "production")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_professor")
    private Long idProfessor;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "level_of_education")
    private String levelOfEducation;

    @Column(name = "alma_matter")
    private String almaMatter;

    @Column(name = "institutional_website")
    private String institutionalWebsite;

    public Professor() {
    }

    public Professor(Long idProfessor, String specialization, String levelOfEducation, String almaMatter, String institutionalWebsite) {
        this.idProfessor = idProfessor;
        this.specialization = specialization;
        this.levelOfEducation = levelOfEducation;
        this.almaMatter = almaMatter;
        this.institutionalWebsite = institutionalWebsite;
    }

    public Professor(String specialization, String levelOfEducation, String almaMatter, String institutionalWebsite) {
        this.specialization = specialization;
        this.levelOfEducation = levelOfEducation;
        this.almaMatter = almaMatter;
        this.institutionalWebsite = institutionalWebsite;
    }

    public Long getIdProfessor() {
        return idProfessor;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getLevelOfEducation() {
        return levelOfEducation;
    }

    public void setLevelOfEducation(String levelOfEducation) {
        this.levelOfEducation = levelOfEducation;
    }

    public String getAlmaMatter() {
        return almaMatter;
    }

    public void setAlmaMatter(String almaMatter) {
        this.almaMatter = almaMatter;
    }

    public String getInstitutionalWebsite() {
        return institutionalWebsite;
    }

    public void setInstitutionalWebsite(String institutionalWebsite) {
        this.institutionalWebsite = institutionalWebsite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Professor)) return false;
        Professor professor = (Professor) o;
        return Objects.equals(idProfessor, professor.idProfessor) &&
                Objects.equals(specialization, professor.specialization) &&
                Objects.equals(levelOfEducation, professor.levelOfEducation) &&
                Objects.equals(almaMatter, professor.almaMatter) &&
                Objects.equals(institutionalWebsite, professor.institutionalWebsite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProfessor, specialization, levelOfEducation, almaMatter, institutionalWebsite);
    }
}

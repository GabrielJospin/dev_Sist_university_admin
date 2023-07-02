package br.usp.josin.university_admin.entities.inter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "researcher", schema = "production")
public class Researcher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_researcher")
    private Long idResearcher;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "is_postgraduate_student")
    private Boolean isPostgraduateStudent;

    public Researcher() {
    }

    public Researcher(Long idResearcher, String specialization, Boolean isPostgraduateStudent) {
        this.idResearcher = idResearcher;
        this.specialization = specialization;
        this.isPostgraduateStudent = isPostgraduateStudent;
    }

    public Researcher(String specialization, Boolean isPostgraduateStudent) {
        this.specialization = specialization;
        this.isPostgraduateStudent = isPostgraduateStudent;
    }

    public Long getIdResearcher() {
        return idResearcher;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Boolean getPostgraduateStudent() {
        return isPostgraduateStudent;
    }

    public void setPostgraduateStudent(Boolean postgraduateStudent) {
        isPostgraduateStudent = postgraduateStudent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Researcher)) return false;
        Researcher that = (Researcher) o;
        return Objects.equals(idResearcher, that.idResearcher) &&
                Objects.equals(specialization, that.specialization) &&
                Objects.equals(isPostgraduateStudent, that.isPostgraduateStudent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idResearcher, specialization, isPostgraduateStudent);
    }
}

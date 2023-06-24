package br.usp.josin.university_admin.entities.intra;

import br.usp.josin.university_admin.entities.inter.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "spec_person")
public class SpecPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name="id_person", referencedColumnName = "id_person")
    private Person person;

    @OneToOne
    @JoinColumn(name="id_student", referencedColumnName = "id_student")
    private Student student;

    @OneToOne
    @JoinColumn(name = "id_professor", referencedColumnName = "id_professor")
    private Professor professor;

    @OneToOne
    @JoinColumn(name = "id_researcher", referencedColumnName = "id_researcher")
    private Researcher researcher;

    @OneToOne
    @JoinColumn(name = "id_employer", referencedColumnName = "id_employer")
    private Employer employer;

    public SpecPerson() {
    }

    public SpecPerson(Long id, Person person, Student student, Professor professor, Researcher researcher, Employer employer) {
        this.id = id;
        this.person = person;
        this.student = student;
        this.professor = professor;
        this.researcher = researcher;
        this.employer = employer;
    }

    public SpecPerson(Person person, Student student, Professor professor, Researcher researcher, Employer employer) {
        this.person = person;
        this.student = student;
        this.professor = professor;
        this.researcher = researcher;
        this.employer = employer;
    }

    public Long getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Researcher getResearcher() {
        return researcher;
    }

    public void setResearcher(Researcher researcher) {
        this.researcher = researcher;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpecPerson)) return false;
        SpecPerson that = (SpecPerson) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(person, that.person) &&
                Objects.equals(student, that.student) &&
                Objects.equals(professor, that.professor) &&
                Objects.equals(researcher, that.researcher) &&
                Objects.equals(employer, that.employer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, person, student, professor, researcher, employer);
    }
}


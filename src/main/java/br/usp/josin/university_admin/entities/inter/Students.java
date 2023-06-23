package br.usp.josin.university_admin.entities.inter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "students")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_students")
    private Long idStudents;

    @Column(name = "course")
    private String course;

    @Column(name = "entry_grade")
    private double entryGrade;

    public Students() {
    }

    public Students(Long idStudents, String course, double entryGrade) {
        this.idStudents = idStudents;
        this.course = course;
        this.entryGrade = entryGrade;
    }

    public Students(String course, double entryGrade) {
        this.course = course;
        this.entryGrade = entryGrade;
    }

    public Long getIdStudents() {
        return idStudents;
    }

    public void setIdStudents(Long idStudents) {
        this.idStudents = idStudents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Students)) return false;
        Students students = (Students) o;
        return Double.compare(students.entryGrade, entryGrade) == 0 && Objects.equals(idStudents, students.idStudents) && Objects.equals(course, students.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStudents, course, entryGrade);
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getEntryGrade() {
        return entryGrade;
    }

    public void setEntryGrade(double entryGrade) {
        this.entryGrade = entryGrade;
    }
}

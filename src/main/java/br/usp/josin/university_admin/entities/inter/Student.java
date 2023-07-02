package br.usp.josin.university_admin.entities.inter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "students", schema = "production")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student")
    private Long idStudent;

    @Column(name = "course")
    private String course;

    @Column(name = "entry_grade")
    private double entryGrade;

    public Student() {
    }

    public Student(Long idStudent, String course, double entryGrade) {
        this.idStudent = idStudent;
        this.course = course;
        this.entryGrade = entryGrade;
    }

    public Student(String course, double entryGrade) {
        this.course = course;
        this.entryGrade = entryGrade;
    }

    public Long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Long idStudents) {
        this.idStudent = idStudents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Double.compare(student.entryGrade, entryGrade) == 0 && Objects.equals(idStudent, student.idStudent) && Objects.equals(course, student.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStudent, course, entryGrade);
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

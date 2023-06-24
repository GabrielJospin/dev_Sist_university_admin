package br.usp.josin.university_admin.entities.intra;

import br.usp.josin.university_admin.entities.inter.Course;
import br.usp.josin.university_admin.entities.inter.Professor;
import br.usp.josin.university_admin.entities.inter.Student;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "offering")
public class Offering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToMany
    @JoinColumn(name = "id_student", referencedColumnName = "id_student")
    private List<Student> student;

    @ManyToOne
    @JoinColumn(name = "id_professor", referencedColumnName = "id_professor")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name="id_course", referencedColumnName = "id_course")
    private Course course;

    @Column(name = "init_date")
    private Date initDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column (name = "grade")
    private Double grade;

    @Column(name = "classroom")
    private String classroom;

    @Column(name = "institution")
    private String institution;

    public Offering() {
    }

    public Offering(Long id, List<Student> student, Professor professor, Course course, Date initDate, Date endDate, Double grade, String classroom, String institution) {
        this.id = id;
        this.student = student;
        this.professor = professor;
        this.course = course;
        this.initDate = initDate;
        this.endDate = endDate;
        this.grade = grade;
        this.classroom = classroom;
        this.institution = institution;
    }

    public Offering(List<Student> student, Professor professor, Course course, Date initDate, Date endDate, Double grade, String classroom, String institution) {
        this.student = student;
        this.professor = professor;
        this.course = course;
        this.initDate = initDate;
        this.endDate = endDate;
        this.grade = grade;
        this.classroom = classroom;
        this.institution = institution;
    }


    public Long getId() {
        return id;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getInitDate() {
        return initDate;
    }

    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Offering)) return false;
        Offering offering = (Offering) o;
        return Objects.equals(id, offering.id) &&
                Objects.equals(student, offering.student) &&
                Objects.equals(professor, offering.professor) &&
                Objects.equals(course, offering.course) &&
                Objects.equals(initDate, offering.initDate) &&
                Objects.equals(endDate, offering.endDate) &&
                Objects.equals(grade, offering.grade) &&
                Objects.equals(classroom, offering.classroom) &&
                Objects.equals(institution, offering.institution);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, student, professor, course, initDate, endDate, grade, classroom, institution);
    }
}

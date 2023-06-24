package br.usp.josin.university_admin.entities.inter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_courses")
    private Long idCourses;

    @Column(name = "cod_course")
    private String codCourse;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "menu")
    private String menu;

    @Column(name = "institution")
    private String institution;

    @Column(name = "creation")
    private Date creation;

    public Course() {
    }

    public Course(Long idCourses, String codCourse, String name, String description, String menu, String institution, Date creation) {
        this.idCourses = idCourses;
        this.codCourse = codCourse;
        this.name = name;
        this.description = description;
        this.menu = menu;
        this.institution = institution;
        this.creation = creation;
    }

    public Course(String codCourse, String name, String description, String menu, String institution, Date creation) {
        this.codCourse = codCourse;
        this.name = name;
        this.description = description;
        this.menu = menu;
        this.institution = institution;
        this.creation = creation;
    }

    public Long getIdCourses() {
        return idCourses;
    }

    public String getCodCourse() {
        return codCourse;
    }

    public void setCodCourse(String codCourse) {
        this.codCourse = codCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return Objects.equals(idCourses, course.idCourses) &&
                Objects.equals(codCourse, course.codCourse) &&
                Objects.equals(name, course.name) &&
                Objects.equals(description, course.description) &&
                Objects.equals(menu, course.menu) &&
                Objects.equals(institution, course.institution) &&
                Objects.equals(creation, course.creation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCourses, codCourse, name, description, menu, institution, creation);
    }
}


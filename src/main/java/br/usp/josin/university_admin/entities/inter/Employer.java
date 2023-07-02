package br.usp.josin.university_admin.entities.inter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employers", schema = "production")
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employer")
    private Long idEmployer;

    @Column(name = "function")
    private String function;

    @Column(name = "salary")
    private int salary;

    public Employer() {
    }

    public Employer(Long idEmployer, String function, int salary) {
        this.idEmployer = idEmployer;
        this.function = function;
        this.salary = salary;
    }

    public Employer(String function, int salary) {
        this.function = function;
        this.salary = salary;
    }

    public Long getIdEmployer() {
        return idEmployer;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employer)) return false;
        Employer employer = (Employer) o;
        return salary == employer.salary &&
                Objects.equals(idEmployer, employer.idEmployer) &&
                Objects.equals(function, employer.function);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmployer, function, salary);
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

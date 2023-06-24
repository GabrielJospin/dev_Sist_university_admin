package br.usp.josin.university_admin.entities.inter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employers")
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employers")
    private Long idEmployers;

    @Column(name = "function")
    private String function;

    @Column(name = "salary")
    private int salary;

    public Employer() {
    }

    public Employer(Long idEmployers, String function, int salary) {
        this.idEmployers = idEmployers;
        this.function = function;
        this.salary = salary;
    }

    public Employer(String function, int salary) {
        this.function = function;
        this.salary = salary;
    }

    public Long getIdEmployers() {
        return idEmployers;
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
                Objects.equals(idEmployers, employer.idEmployers) &&
                Objects.equals(function, employer.function);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmployers, function, salary);
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

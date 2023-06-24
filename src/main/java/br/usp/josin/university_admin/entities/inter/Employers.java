package br.usp.josin.university_admin.entities.inter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employers")
public class Employers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employers")
    private Long idEmployers;

    @Column(name = "function")
    private String function;

    @Column(name = "salary")
    private int salary;

    public Employers() {
    }

    public Employers(Long idEmployers, String function, int salary) {
        this.idEmployers = idEmployers;
        this.function = function;
        this.salary = salary;
    }

    public Employers(String function, int salary) {
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
        if (!(o instanceof Employers)) return false;
        Employers employers = (Employers) o;
        return salary == employers.salary &&
                Objects.equals(idEmployers, employers.idEmployers) &&
                Objects.equals(function, employers.function);
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

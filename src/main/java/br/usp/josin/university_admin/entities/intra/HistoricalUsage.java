package br.usp.josin.university_admin.entities.intra;

import br.usp.josin.university_admin.entities.inter.Person;
import br.usp.josin.university_admin.entities.inter.Service;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "historical_usage")
public class HistoricalUsage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="id_person", referencedColumnName = "id_person")
    private Person person;

    @ManyToOne
    @JoinColumn(name="id_service", referencedColumnName = "id_service")
    private Service service;

    @Column(name = "datetime")
    private Timestamp datetime;

    public HistoricalUsage() {
    }

    public HistoricalUsage(Long id, Person person, Service service, Timestamp datetime) {
        this.id = id;
        this.person = person;
        this.service = service;
        this.datetime = datetime;
    }

    public HistoricalUsage(Person person, Service service, Timestamp datetime) {
        this.person = person;
        this.service = service;
        this.datetime = datetime;
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

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HistoricalUsage)) return false;
        HistoricalUsage that = (HistoricalUsage) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(person, that.person) &&
                Objects.equals(service, that.service) &&
                Objects.equals(datetime, that.datetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, person, service, datetime);
    }
}

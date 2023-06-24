package br.usp.josin.university_admin.entities.intra;

import br.usp.josin.university_admin.entities.inter.Person;
import br.usp.josin.university_admin.entities.inter.Profile;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "rel_person_profile")
public class RelPersonProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="id_person", referencedColumnName = "id_person")
    private Person person;

    @ManyToOne
    @JoinColumn(name="id_profile", referencedColumnName = "id_profile")
    private Profile profile;

    @Column(name="init_date")
    private Date initDate;

    @Column(name="end_date")
    private Date endDate;

    public RelPersonProfile() {
    }

    public RelPersonProfile(Long id, Person person, Profile profile, Date initDate, Date endDate) {
        this.id = id;
        this.person = person;
        this.profile = profile;
        this.initDate = initDate;
        this.endDate = endDate;
    }

    public RelPersonProfile(Person person, Profile profile, Date initDate, Date endDate) {
        this.person = person;
        this.profile = profile;
        this.initDate = initDate;
        this.endDate = endDate;
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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RelPersonProfile)) return false;
        RelPersonProfile that = (RelPersonProfile) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(person, that.person) &&
                Objects.equals(profile, that.profile) &&
                Objects.equals(initDate, that.initDate) &&
                Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, person, profile, initDate, endDate);
    }
}

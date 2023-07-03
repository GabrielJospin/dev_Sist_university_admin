package br.usp.josin.university_admin.entities.inter;

import javax.persistence.*;
import java.util.Objects;

@Embeddable
@Entity
@Table(name = "profiles", schema = "production")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profile")
    private Long idProfile;

    @Column(name="code_profile")
    private String codProfile;

    @Column(name="description")
    private String description;

    @Column(name="name")
    private String name;

    public Profile(Long idProfile, String codProfile, String description, String name) {
        this.idProfile = idProfile;
        this.codProfile = codProfile;
        this.description = description;
        this.name = name;
    }

    public Profile(String codProfile, String description, String name) {
        this.codProfile = codProfile;
        this.description = description;
        this.name = name;
    }

    public Profile() {
    }

    public Long getIdProfile() {
        return idProfile;
    }

    public String getCodProfile() {
        return codProfile;
    }

    public void setCodProfile(String codProfile) {
        this.codProfile = codProfile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profile)) return false;
        Profile profile = (Profile) o;
        return Objects.equals(idProfile, profile.idProfile) &&
                Objects.equals(codProfile, profile.codProfile) &&
                Objects.equals(description, profile.description) &&
                Objects.equals(name, profile.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProfile, codProfile, description, name);
    }
}

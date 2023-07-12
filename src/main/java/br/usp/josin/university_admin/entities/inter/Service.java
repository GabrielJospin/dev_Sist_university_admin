package br.usp.josin.university_admin.entities.inter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "services", schema = "production")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_service")
    private Long idService;

    @Column(name = "code_service")
    private String codeService;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name="id_profile", referencedColumnName = "id_profile")
    private Profile profile;

    public Service() {
    }

    public Service(Long idService, String codeService, String description, Profile profile) {
        this.idService = idService;
        this.codeService = codeService;
        this.description = description;
        this.profile = profile;
    }

    public Service(String codeService, String description, Profile profile) {
        this.codeService = codeService;
        this.description = description;
        this.profile = profile;
    }

    public Long getIdService() {
        return idService;
    }

    public String getCodeService() {
        return codeService;
    }

    public void setCodeService(String codeService) {
        this.codeService = codeService;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Service)) return false;
        Service service = (Service) o;
        return Objects.equals(idService, service.idService) &&
                Objects.equals(codeService, service.codeService) &&
                Objects.equals(description, service.description) &&
                Objects.equals(profile, service.profile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idService, codeService, description, profile);
    }
}

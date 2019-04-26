package dumaya.dev.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


@Entity
public class Topo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 40)
    @NotNull
    private String site;

    @Column(nullable = false, length = 40)
    @NotBlank
    private String auteur;

    @Column(nullable = false, length = 40)
    @NotBlank
    private String lieuDuPret;

    @Column(name = "dateMaj", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Date dateMaj;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getLieuDuPret() {
        return lieuDuPret;
    }

    public void setLieuDuPret(String lieuDuPret) {
        this.lieuDuPret = lieuDuPret;
    }

    public Date getDateMaj() {
        return dateMaj;
    }

    public void setDateMaj(Date dateMaj) {
        this.dateMaj = dateMaj;
    }
}

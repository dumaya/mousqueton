package dumaya.dev.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;


/**
 * Description d'un Topo
 */
@Entity
public class Topo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40)
    @NotBlank
    private String nom;

    @Column(length = 500)
    private String description;

    @Column(length = 60)
    @NotBlank
    private String lieu;

    @Column(nullable = false)
    private boolean dispoPret;

    @Column(name = "dateParution", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Date dateParution;

    @Column(length = 40)
    private String auteur;

    @ManyToOne
    private User userProprietaire;

    @ManyToOne
    private User userEmprunteur;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Date getDateParution() {
        return dateParution;
    }

    public void setDateParution(Date dateParution) {
        this.dateParution = dateParution;
    }

    public String getAuteur() {
        return auteur;
    }
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public boolean isDispoPret() {
        return dispoPret;
    }

    public void setDispoPret(boolean dispoPret) {
        this.dispoPret = dispoPret;
    }

    public User getUserProprietaire() {
        return userProprietaire;
    }

    public void setUserProprietaire(User userProprietaire) {
        this.userProprietaire = userProprietaire;
    }

    public User getUserEmprunteur() {
        return userEmprunteur;
    }

    public void setUserEmprunteur(User userEmprunteur) {
        this.userEmprunteur = userEmprunteur;
    }
}

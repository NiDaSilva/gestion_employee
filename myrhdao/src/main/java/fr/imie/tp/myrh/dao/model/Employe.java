package fr.imie.tp.myrh.dao.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ndasilva on 30/01/2017.
 */
@Entity
@Table(name = "T_EMPLOYE")

@NamedQueries({
	@NamedQuery(name="Employe.findAll", query="SELECT e FROM Employe e"),
	@NamedQuery(name="Employe.findByID", query="SELECT e FROM Employe e WHERE e.id= :idVar"),
	@NamedQuery(name="Employe.findByName", query="SELECT e FROM Employe e WHERE e.nom= :nomVar"),
	@NamedQuery(name="Employe.findHighSalary", query="SELECT e FROM Employe e WHERE e.salaire > 40000")
})
public class Employe implements Serializable{

	private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "empl_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "empl_nom")
    private String nom;

    @Column(name = "empl_prenom")
    private String prenom;

    @Column(name = "empl_numSecu")
    private String num_secu;

    @Column(name = "empl_salaire")
    private double salaire;

    @Column(name = "empl_dateEmb")
    @Temporal(TemporalType.DATE)
    private Date dateEmbauche;

    @Column(name = "empl_dateFinEmb")
    @Temporal(TemporalType.DATE)
    private Date dateFinEmbauche;
    
    /**
     * Liste des projets de l'employé.
     */
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REFRESH })
    @JoinTable(name = "T_TRAVAIL", joinColumns = @JoinColumn(name = "tra_empl_id"),
            inverseJoinColumns = @JoinColumn(name = "tra_pro_id"))
    private Set<Projet> projets = new HashSet<Projet>();

    public Employe(String nom, String prenom, String num_secu, double salaire, Date dateEmbauche, Date dateFinEmbauche) {
        this.nom = nom;
        this.prenom = prenom;
        this.num_secu = num_secu;
        this.salaire = salaire;
        this.dateEmbauche = dateEmbauche;
        this.dateFinEmbauche = dateFinEmbauche;
    }
    public Employe() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNum_secu() {
        return num_secu;
    }

    public void setNum_secu(String num_secu) {
        this.num_secu = num_secu;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public Date getDateFinEmbauche() {
        return dateFinEmbauche;
    }

    public void setDateFinEmbauche(Date dateFinEmbauche) {
        this.dateFinEmbauche = dateFinEmbauche;
    }
}

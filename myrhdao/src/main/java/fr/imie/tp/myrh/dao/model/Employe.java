package fr.imie.tp.myrh.dao.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ndasilva on 30/01/2017.
 */
@Entity
@Table(name = "T_EMPLOYE")
public class Employe implements Serializable{

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "PRENOM")
    private String prenom;

    @Column(name = "NUM_SECU")
    private String num_secu;

    @Column(name = "SALAIRE")
    private double salaire;

    @Column(name = "DATE_EMB")
    @Temporal(TemporalType.DATE)
    private Date dateEmbauche;

    @Column(name = "DATE_FIN_EMB")
    @Temporal(TemporalType.DATE)
    private Date dateFinEmbauche;

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

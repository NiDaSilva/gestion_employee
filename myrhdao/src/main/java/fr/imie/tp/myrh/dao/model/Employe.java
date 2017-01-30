package fr.imie.tp.myrh.dao.model;

import java.sql.Date;

/**
 * Created by ndasilva on 30/01/2017.
 */
public class Employe {
    private long id;
    private String nom;
    private String Prenom;
    private String Num_secu;
    private double salaire;
    private Date dateEmbauche;
    private Date dateFinEmbauche;

    public Employe(long id, String nom, String prenom, String num_secu, double salaire, Date dateEmbauche, Date dateFinEmbauche) {
        this.id = id;
        this.nom = nom;
        Prenom = prenom;
        Num_secu = num_secu;
        this.salaire = salaire;
        this.dateEmbauche = dateEmbauche;
        this.dateFinEmbauche = dateFinEmbauche;
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
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getNum_secu() {
        return Num_secu;
    }

    public void setNum_secu(String num_secu) {
        Num_secu = num_secu;
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

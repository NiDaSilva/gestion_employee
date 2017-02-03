package fr.imie.tp.myrh.ui.bean;

import fr.imie.tp.myrh.dao.model.Departement;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name="employeBean")
public class EmployeBean implements Serializable{

	private static final long serialVersionUID = 1L;

    private long id;

    private String nom;

    private String prenom;

	private Departement departement;

    private String num_secu;

    private double salaire;

    private Date dateEmbauche;

    private Date dateFinEmbauche;

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

    
	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
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

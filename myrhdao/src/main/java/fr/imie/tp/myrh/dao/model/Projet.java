package fr.imie.tp.myrh.dao.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_PROJET")

@NamedQueries({
	@NamedQuery(name="Projet.findAll", query="SELECT p FROM Projet p"),
	@NamedQuery(name="Projet.findByID", query="SELECT p FROM Projet p WHERE p.id= :idVar"),
	@NamedQuery(name="Projet.findByCode", query="SELECT p FROM Projet p WHERE p.code= :codeVar")
})
public class Projet implements Serializable{

	private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "pro_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "pro_code")
    private String code;

    @Column(name = "pro_description")
    private String description;

    @Column(name = "pro_dateDeb")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Column(name = "pro_dateFin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    
    /**
     * Liste des employés sur le Projet.
     */
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REFRESH })
    @JoinTable(name = "T_TRAVAIL", joinColumns = @JoinColumn(name = "tra_pro_id"),
            inverseJoinColumns = @JoinColumn(name = "tra_empl_id"))
    private Set<Employe> employes = new HashSet<Employe>();

	public Projet(String code, String description, Date dateDebut, Date dateFin, Set<Employe> employes) {
		this.code = code;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.employes = employes;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the dateDebut
	 */
	public Date getDateDebut() {
		return dateDebut;
	}

	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return the dateFin
	 */
	public Date getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * @return the employes
	 */
	public Set<Employe> getEmployes() {
		return employes;
	}

	/**
	 * @param employes the employes to set
	 */
	public void setEmployes(Set<Employe> employes) {
		this.employes = employes;
	}

}

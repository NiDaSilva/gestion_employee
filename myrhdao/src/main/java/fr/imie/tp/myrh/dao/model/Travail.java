package fr.imie.tp.myrh.dao.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ndasilva on 30/01/2017.
 */
@Entity
@Table(name = "T_TRAVAIL")

@NamedQueries({
	@NamedQuery(name="Travail.findAll", query="SELECT t FROM Travail t"),
	@NamedQuery(name="Travail.findByID", query="SELECT t FROM Travail t WHERE t.id= :idVar")
})
public class Travail implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REFRESH })
    @JoinColumn(name = "tra_empl_id")
	private Employe employe;

	@Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REFRESH })
    @JoinColumn(name = "tra_pro_id")
	private Projet projet;

    @Column(name = "tra_date")
    private Date date;

    @Column(name = "tra_duree")
    private int duree;

    @Column(name = "tra_commentaire")
    private String commentaire;

    /**
	 * @param employe
	 * @param projet
	 * @param date
	 * @param duree
	 * @param comentaire
	 */
	public Travail(Employe employe, Projet projet, Date date, int duree, String commentaire) {
		this.employe = employe;
		this.projet = projet;
		this.date = date;
		this.duree = duree;
		this.commentaire = commentaire;
	}

	public Travail() {
    }

	/**
	 * @return the employe
	 */
	public Employe getEmploye() {
		return employe;
	}

	/**
	 * @param employe the employe to set
	 */
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	/**
	 * @return the projet
	 */
	public Projet getProjet() {
		return projet;
	}

	/**
	 * @param projet the projet to set
	 */
	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the duree
	 */
	public int getDuree() {
		return duree;
	}

	/**
	 * @param duree the duree to set
	 */
	public void setDuree(int duree) {
		this.duree = duree;
	}

	/**
	 * @return the commentaire
	 */
	public String getCommentaire() {
		return commentaire;
	}

	/**
	 * @param commentaire the commentaire to set
	 */
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
}

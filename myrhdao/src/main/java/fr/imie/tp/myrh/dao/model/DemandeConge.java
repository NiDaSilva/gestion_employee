package fr.imie.tp.myrh.dao.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ndasilva on 31/01/2017.
 */
@Entity
@Table(name = "T_DEMANDE_CONGE")
@NamedQueries({
        @NamedQuery(name="DemandeConge.findAll", query="SELECT dc FROM DemandeConge dc"),
        @NamedQuery(name="DemandeConge.findByEmploye", query="SELECT dc FROM DemandeConge dc WHERE dc.employe = :idVar")
})
public class DemandeConge implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    @Id
    @Column(name = "demc_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REFRESH })
    @JoinColumn(name = "demc_empl_id")
    private Employe employe;

    @Column(name = "demc_status")
    private String status;

    @Column(name = "demc_motif")
    private String motif;

    @Column(name = "demc_nbJour")
    private int nbJour;

    @Column(name = "demc_dateDem")
    private Date dateDemande;

    @Column(name = "demc_dateDebut")
    private Date dateDebut;

    @Column(name = "demc_dateFin")
    private Date dateFin;

    public DemandeConge(Employe employe, String status, String motif, int nbJour, Date dateDemande, Date dateDebut, Date dateFin) {
        this.employe = employe;
        this.status = status;
        this.motif = motif;
        this.nbJour = nbJour;
        this.dateDemande = dateDemande;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public DemandeConge() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNbJour() {
        return nbJour;
    }

    public void setNbJour(int nbJour) {
        this.nbJour = nbJour;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
}

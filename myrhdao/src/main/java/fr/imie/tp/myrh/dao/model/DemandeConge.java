package fr.imie.tp.myrh.dao.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ndasilva on 31/01/2017.
 */
public class DemandeConge implements Serializable{
    @Id
    @Column(name = "demc_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "demc_dateDem")
    private Date dateDemande;

    @Column(name = "demc_dateDebut")
    private Date dateDebut;

    @Column(name = "demc_dateFin")
    private Date dateFin;

    @Column(name = "demc_motif")
    private String motif;

    @Column(name = "demc_status")
    private String status;

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

    public String getNbJour() {
        return nbJour;
    }

    public void setNbJour(String nbJour) {
        this.nbJour = nbJour;
    }

    @Column(name = "demc_nbJour")
    private String nbJour;
}

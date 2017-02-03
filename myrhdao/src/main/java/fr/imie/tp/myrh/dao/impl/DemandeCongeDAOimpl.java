package fr.imie.tp.myrh.dao.impl;

import fr.imie.tp.myrh.dao.ifc.IDemandeCongeDAO;
import fr.imie.tp.myrh.dao.model.DemandeConge;
import fr.imie.tp.myrh.dao.model.Employe;
import fr.imie.tp.myrh.dao.model.Status;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class DemandeCongeDAOimpl implements IDemandeCongeDAO{
	  EntityManager em = EntityManagerImpl.getEm();

    public void addDemande(DemandeConge dem){
        System.out.println("\nCREATION D'UNE DEMANDE");
        EntityTransaction trx = em.getTransaction();
        trx.begin();
        em.persist(dem);
        trx.commit();
		System.out.println("Demande de Conge de "+dem.getEmploye().getNom()+" "+dem.getEmploye().getPrenom()+" enregistré avec l'id "+dem.getId());
    }


    public void addDemande(Employe employe, Status status, String motif, int nbJour, Date dateDemande, Date dateDebut, Date dateFin){
         DemandeConge dem = new DemandeConge();
         dem.setEmploye(employe);
         dem.setStatus(status);
         dem.setMotif(motif);
         dem.setNbJour(nbJour);
         dem.setDateDemande(dateDemande);
         dem.setDateDebut(dateDebut);
         dem.setDateFin(dateFin);
         addDemande(dem);
    }

    public List<DemandeConge> getAllDemande(){
        System.out.println("\nListe des Demandes de congés");
        TypedQuery<DemandeConge> query = em.createNamedQuery("DemandeConge.findAll", DemandeConge.class);
        return query.getResultList();
    }

    public List<DemandeConge> getDemandeByEmploye(Employe empl){
        System.out.println("\nListe des Demandes de congés pour un employe");
        TypedQuery<DemandeConge> query = em.createNamedQuery("DemandeConge.findByEmploye", DemandeConge.class);
        query.setParameter("idVar", empl);
        return query.getResultList();
    }
}

package fr.imie.tp.myrh.dao.impl;

import fr.imie.tp.myrh.dao.ifc.IDemandeCongeDAO;
import fr.imie.tp.myrh.dao.model.DemandeConge;
import fr.imie.tp.myrh.dao.model.Employe;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ndasilva on 01/02/2017.
 */
public class DemandeCongeDAOimpl implements IDemandeCongeDAO{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRhPersistenceUnit");
    EntityManager em = emf.createEntityManager();

    public void addDemande(DemandeConge dem){
        System.out.println("\nCREATION D'UNE DEMANDE");
        EntityTransaction trx = em.getTransaction();
        trx.begin();
        em.persist(dem);
        trx.commit();
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

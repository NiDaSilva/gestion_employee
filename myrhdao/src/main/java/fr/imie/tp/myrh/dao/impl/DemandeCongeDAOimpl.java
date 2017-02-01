package fr.imie.tp.myrh.dao.impl;

import fr.imie.tp.myrh.dao.ifc.IDemandeCongeDAO;
import fr.imie.tp.myrh.dao.model.DemandeConge;
import fr.imie.tp.myrh.dao.model.Employe;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by ndasilva on 01/02/2017.
 */
public class DemandeCongeDAOimpl implements IDemandeCongeDAO{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRhPersistenceUnit");
    EntityManager em = emf.createEntityManager();

    public List<DemandeConge> getAllDemande(){
        System.out.println("\nListe des Demandes de congés");
        TypedQuery<DemandeConge> query = em.createNamedQuery("DemandeConge.findAll", DemandeConge.class);
        return query.getResultList();
    }
}

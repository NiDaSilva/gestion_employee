package fr.imie.tp.myrh.dao.impl;

import fr.imie.tp.myrh.dao.ifc.IStatusDAO;
import fr.imie.tp.myrh.dao.model.Status;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import java.util.List;

/**
 * Created by ndasilva on 02/02/2017.
 */
public class StatusDAOimpl implements IStatusDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRhPersistenceUnit");
    EntityManager em = emf.createEntityManager();

    public void addStatus(Status stat){
        System.out.println("\nCREATION D'UN STATUS");
        EntityTransaction trx = em.getTransaction();
        trx.begin();
        em.persist(stat);
        trx.commit();
    }

    public List<Status> getAllStatus(){
        System.out.println("\nListe des Demandes de congés");
        TypedQuery<Status> query = em.createNamedQuery("Status.findAll", Status.class);
        return query.getResultList();
    }
}

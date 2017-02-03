package fr.imie.tp.myrh.dao.impl;

import fr.imie.tp.myrh.dao.ifc.IStatusDAO;
import fr.imie.tp.myrh.dao.model.Status;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import java.util.List;

public class StatusDAOimpl implements IStatusDAO {
	  EntityManager em = EntityManagerImpl.getEm();

    public void addStatus(Status stat){
        System.out.println("\nCREATION D'UN STATUS");
        EntityTransaction trx = em.getTransaction();
        trx.begin();
        em.persist(stat);
        trx.commit();
		System.out.println("Status "+stat.getLibelle()+" enregistré avec l'id "+stat.getId());
    }

    public void addStatus(String libelle){
       Status stat = new Status(libelle);
       addStatus(stat);
    }

    public List<Status> getAllStatus(){
        System.out.println("\nListe des Status :");
        TypedQuery<Status> query = em.createNamedQuery("Status.findAll", Status.class);
        return query.getResultList();
    }
}

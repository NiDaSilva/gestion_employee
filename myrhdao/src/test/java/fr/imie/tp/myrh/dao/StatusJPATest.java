package fr.imie.tp.myrh.dao;

import fr.imie.tp.myrh.dao.model.Status;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by ndasilva on 02/02/2017.
 */
public class StatusJPATest {
    public static void main(String[] args){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRhPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        System.out.println("\nCREATION D'UNE DEMANDE");
        EntityTransaction trx = em.getTransaction();
        trx.begin();
        Status stat1 = new Status("Demandé");
        Status stat2 = new Status("Accepté");
        Status stat3 = new Status("Refusé");
        Status stat4 = new Status("En Cours D'examen");
        em.persist(stat1);
        em.persist(stat2);
        em.persist(stat3);
        em.persist(stat4);
        trx.commit();

    }
}

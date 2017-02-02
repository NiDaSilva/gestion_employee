package fr.imie.tp.myrh.dao;

import fr.imie.tp.myrh.dao.model.DemandeConge;
import fr.imie.tp.myrh.dao.model.Employe;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by ndasilva on 01/02/2017.
 */
public class DemandeCongeJPATest {
    public static void main(String[] args) throws ParseException{

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRhPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        System.out.println("\nCREATION D'UNE DEMANDE");
        EntityTransaction trx = em.getTransaction();
        trx.begin();
        Employe emp = new Employe("Da Silva", "Nicolas", null, "123456789", 60000, sdf.parse("25/12/2016"), sdf.parse("25/12/2018"));
        DemandeConge dem=new DemandeConge(emp,"En Cours","Vacances",5,sdf.parse("20/03/2016"), sdf.parse("02/04/2016"), sdf.parse("12/02/2016"));
        em.persist(dem);
        trx.commit();

        System.out.println("\nListe des Demandes de congés");
        TypedQuery<DemandeConge> query = em.createNamedQuery("DemandeConge.findAll", DemandeConge.class);
        for(DemandeConge demandeConge : query.getResultList()) {
            System.out.println("\nID : "+demandeConge.getId()+" Nom employe: "+demandeConge.getEmploye().getNom());
        }

        System.out.println("\nListe des Demandes de congés pour un employe");
        TypedQuery<DemandeConge> queryAll = em.createNamedQuery("DemandeConge.findByEmploye", DemandeConge.class);
        for(DemandeConge demandeConge : queryAll.getResultList()) {
            System.out.println("\nID : "+demandeConge.getId());
        }
        em.close();
    }
}

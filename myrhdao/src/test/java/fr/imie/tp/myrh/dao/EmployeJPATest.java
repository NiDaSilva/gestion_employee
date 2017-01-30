package fr.imie.tp.myrh.dao;

import fr.imie.tp.myrh.dao.model.Employe;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by ndasilva on 30/01/2017.
 */
public class EmployeJPATest {

    public static void main(String[] args) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRhPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        System.out.println("\nRequête1: CREATION D'UN EMPLOYE");
        EntityTransaction trx = em.getTransaction();
        trx.begin();
        Employe emp = new Employe("Da Silva", "Nicolas","123456789",60000, sdf.parse("25/12/2016"),sdf.parse("25/12/2018"));
        em.persist(emp);
        System.out.println("Utilisateur enregistrer avec l'id"+emp.getId());


        Employe emp1 = new Employe();
        emp1.setNom("Menant");
        emp1.setPrenom("Kevin");
        emp1.setNum_secu("9897654321");
        emp1.setDateEmbauche(sdf.parse("24/12/2016"));
        emp1.setDateFinEmbauche(sdf.parse("24/12/2018"));
        em.persist(emp1);
        trx.commit();
        em.close();
    }
}

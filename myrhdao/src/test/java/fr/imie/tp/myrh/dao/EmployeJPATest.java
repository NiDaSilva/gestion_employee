package fr.imie.tp.myrh.dao;

import fr.imie.tp.myrh.dao.model.Employe;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by ndasilva on 30/01/2017.
 */
public class EmployeJPATest {

    public static void main(String[] args) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRhPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        
        EntityTransaction trx = em.getTransaction();
        trx.begin();
        
        System.out.println("\nCREATION D'UN EMPLOYE 1");
        Employe emp = new Employe("Da Silva", "Nicolas", "123456789", 60000, sdf.parse("25/12/2016"), sdf.parse("25/12/2018"));
        em.persist(emp);
        System.out.println("Utilisateur enregistrer avec l'id "+emp.getId());
        
        System.out.println("\nCREATION D'UN EMPLOYE 2");
        Employe emp1 = new Employe();
	        emp1.setNom("Menant");
	        emp1.setPrenom("Kevin");
	        emp1.setNum_secu("9897654321");
	        emp1.setDateEmbauche(sdf.parse("24/12/2016"));
	        emp1.setDateFinEmbauche(sdf.parse("24/12/2018"));
        em.persist(emp1);
        System.out.println("Utilisateur enregistrer avec l'id "+emp1.getId());
        
        System.out.println("\nCREATION D'UN EMPLOYE 3");
        Employe emp3 = new Employe("Robin", "Dimitry","53678224",24000, sdf.parse("07/10/2016"),sdf.parse("12/09/2018"));
        em.persist(emp3);
        System.out.println("Utilisateur enregistrer avec l'id "+emp3.getId());
        
        
        // Liste des employés
        System.out.println("\nListe des Employés");
        TypedQuery<Employe> query = em.createNamedQuery("Employe.findAll", Employe.class);
        List<Employe> result = query.getResultList();
        for(Employe employe : result) {
            System.out.println("\nID = "+employe.getId()+" Name = "+employe.getNom());
        }
        
        
        // Trouver l'employé ID 2
        System.out.println("\nAffiche l'employe 2");
        Employe emp2 = em.find(Employe.class, 2l);
        System.out.println("\nEmploye 2 : "+emp2.getNom());
        // Ou
//        System.out.println("\nAffiche l'employe 2");
//        TypedQuery<Employe> query3 = em.createNamedQuery("Employe.findByID", Employe.class);
//        query3.setParameter("idVar", 2l);
//        Employe emp2 = query3.getSingleResult();
//        System.out.println("\nEmploye 2 : "+emp2.getNom());
        
        
        // Consultation de l’employé dont le nom est "Da Silva"
        System.out.println("\nAffiche l'employe dont le nom est Da Silva");
        TypedQuery<Employe> queryName = em.createNamedQuery("Employe.findByName", Employe.class);
        queryName.setParameter("nomVar", "Da Silva");
        Employe empDaSilva = queryName.getSingleResult();
        System.out.println("\nEmploye : "+empDaSilva.getNom());
        
        
        // Liste des employés dont le salaire est > 40 000euro
        System.out.println("\nListe des employés dont le salaire est > 40 000euro");
        TypedQuery<Employe> queryListSalary = em.createNamedQuery("Employe.findHighSalary", Employe.class);
        List<Employe> resultListSalary = queryListSalary.getResultList();
        for(Employe employe : resultListSalary) {
            System.out.println("\nID : "+employe.getId()+" Nom : "+employe.getNom()+" Salaire : "+employe.getSalaire());
        }
        
        
        // Mise à jour de la date de départ d’un employé
        System.out.println("\nMise à jour de la date de départ d’un employé");
        Employe empMAJ = em.find(Employe.class, 3l);
        System.out.println("Date de départ de "+emp3.getPrenom()+ " : "+ emp3.getDateFinEmbauche());
        empMAJ.setDateFinEmbauche(sdf.parse("24/12/2018"));
        System.out.println("Nouvelle date de départ de "+emp3.getPrenom()+ " : "+ emp3.getDateFinEmbauche());
        em.persist(empMAJ);
        
        // Suppression d’un employé N°3 de la base.
        System.out.println("\nSuppression d’un employé N°3 de la base");
        Employe empID3 = em.find(Employe.class, 3l);
        em.remove(empID3);
        
        trx.commit();
        em.close();
    }
}

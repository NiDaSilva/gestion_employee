package fr.imie.tp.myrh.dao;

import fr.imie.tp.myrh.dao.model.Projet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


public class ProjetJPATest {

    public static void main(String[] args) throws ParseException{
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRhPersistenceUnit");
	    EntityManager em = emf.createEntityManager();
	    
	    EntityTransaction trx = em.getTransaction();
	    trx.begin();
	    
	    System.out.println("\nCREATION D'UN PROJET 1");
	    Projet projet1 = new Projet("proj1", "description", sdf.parse("25/12/2016"), sdf.parse("25/12/2017"), null);
	    em.persist(projet1);
	    System.out.println("Projet enregistré avec l'id "+projet1.getId());	    

	    trx.commit();
	    
	    
	    // Liste des Projets
	    System.out.println("\nListe des Projets");
	    TypedQuery<Projet> query = em.createNamedQuery("Projet.findAll", Projet.class);
	    List<Projet> result = query.getResultList();
	    for(Projet projet : result) {
	        System.out.println("\nID : "+projet.getId()+" Nom : "+projet.getCode());
	    }
	    
	    em.close();
	}
}
package fr.imie.tp.myrh.dao;

import fr.imie.tp.myrh.dao.model.Departement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import java.text.ParseException;
import java.util.List;


public class DepartementJPATest {

    public static void main(String[] args) throws ParseException{
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRhPersistenceUnit");
	    EntityManager em = emf.createEntityManager();
	    
	    EntityTransaction trx = em.getTransaction();
	    trx.begin();
	    
	    System.out.println("\nCREATION DE DEPARTEMENTS");
	    Departement depLogi = new Departement("Logistique", "description");
	    Departement depVente = new Departement("Vente", "description");
	    Departement depLivr = new Departement("Livraison", "description");
	    
	    em.persist(depLogi);
	    System.out.println("Departement enregistré avec l'id "+depLogi.getId());
	    em.persist(depVente);
	    System.out.println("Departement enregistré avec l'id "+depVente.getId());	
	    em.persist(depLivr);
	    System.out.println("Departement enregistré avec l'id "+depLivr.getId());	  
	    
	    trx.commit();  
	    
	    
	    // Liste des departements
	    System.out.println("\nListe des departements");
	    TypedQuery<Departement> queryAll = em.createNamedQuery("Departement.findAll", Departement.class);
	    for(Departement departement : queryAll.getResultList()) {
	        System.out.println("\nID : "+departement.getId()+" Nom : "+departement.getCode());
	    }
	    
	    // Trouver par ID
	    System.out.println("\nDepartement 2");
	    TypedQuery<Departement> queryID = em.createNamedQuery("Departement.findByID", Departement.class);
	    queryID.setParameter("idVar", 2l);
		Departement departement = queryID.getSingleResult();
	    System.out.println("\nID : "+departement.getId()+" Nom : "+departement.getCode());
	    
	    em.close();
	}
}
package fr.imie.tp.myrh.dao;

import fr.imie.tp.myrh.dao.impl.EmployeDAOimpl;
import fr.imie.tp.myrh.dao.impl.EntityManagerImpl;
import fr.imie.tp.myrh.dao.impl.ProjetDAOimpl;
import fr.imie.tp.myrh.dao.impl.TravailDAOimpl;
import fr.imie.tp.myrh.dao.model.Employe;
import fr.imie.tp.myrh.dao.model.Projet;
import fr.imie.tp.myrh.dao.model.Travail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


public class TravailJPATest {

    public static void main(String[] args) throws ParseException{
	    TravailDAOimpl travailDAO = new TravailDAOimpl();
	    EmployeDAOimpl employeDAO = new EmployeDAOimpl();
	    ProjetDAOimpl projetDAO = new ProjetDAOimpl();
	    
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		EntityManager em = EntityManagerImpl.getEm();
	    
	    
	    Employe emp1 = new Employe("Da Silva", "Nicolas", null, "123456789", 60000, sdf.parse("25/12/2016"), sdf.parse("25/12/2018"));
	    employeDAO.addEmploye(emp1);
	    
	    Employe emp2 = new Employe("Robin", "Dimitry", null,"53678224",24000, sdf.parse("07/10/2016"),sdf.parse("12/09/2018"));
	    employeDAO.addEmploye(emp2);
	    
	    
	    Projet projet1 = new Projet("proj1", "description", sdf.parse("25/12/2016"), sdf.parse("25/12/2017"));
	    projetDAO.addProjet(projet1);
	    
	    
//	    System.out.println("\nCREATION D'UN TEMPS DE TRAVAIL 1");
//	    Travail trav1 = new Travail(emp1, projet1, sdf.parse("01/02/2017"), 2, "Test jour 1 "+emp1.getNom());
//	    em.persist(trav1);
//	    System.out.println("Travail enregistré pour l'employe "+emp1.getNom()+" sur le projet "+projet1.getCode());	
	    
	    Travail trav1 = new Travail(emp1, projet1, sdf.parse("01/02/2017"), 2, "Test jour 1 "+ emp1.getNom());
	    travailDAO.addTravail(trav1);
		
	    Travail trav2 = new Travail(emp1, projet1, sdf.parse("02/02/2017"), 2, "Test jour 2 "+ emp1.getNom());
		travailDAO.addTravail(trav2);
	    
	    Travail trav3 = new Travail(emp1, projet1, sdf.parse("03/02/2017"), 1, "Test jour 2 "+ emp1.getNom());
	    travailDAO.addTravail(trav3);   
	    
	    Travail trav4 = new Travail(emp2, projet1, sdf.parse("01/02/2017"), 2, "Test jour 1 "+ emp2.getNom());
	    travailDAO.addTravail(trav4);    
	    
	    Travail trav5 = new Travail(emp2, projet1, sdf.parse("05/02/2017"), 2, "Test jour 2 "+ emp2.getNom());
	    travailDAO.addTravail(trav5);
		
	    
	    // Liste des Projets
	    List<Travail> result = travailDAO.getAllTravail();
	    for(Travail travail : result) {
	        System.out.println("Employe : "+travail.getEmploye().getNom()+" Projet : "+ travail.getProjet().getCode());
	    }
	    
	    em.close();
	}
}
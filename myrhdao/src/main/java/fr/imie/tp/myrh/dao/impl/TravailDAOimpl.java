package fr.imie.tp.myrh.dao.impl;

import fr.imie.tp.myrh.dao.ifc.ITravailDAO;
import fr.imie.tp.myrh.dao.model.Employe;
import fr.imie.tp.myrh.dao.model.Projet;
import fr.imie.tp.myrh.dao.model.Travail;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

public class TravailDAOimpl implements ITravailDAO {
	  EntityManager em = EntityManagerImpl.getEm();

    public void addTravail(Travail trav){
		System.out.println("\nCREATION D'UN TEMPS DE TRAVAIL");
		EntityTransaction trx = em.getTransaction();
		trx.begin();
		em.persist(trav);
		trx.commit();
	    System.out.println("Travail enregistré pour l'employe "+trav.getEmploye().getNom()+" sur le projet "+trav.getProjet().getCode());	
	}

	public void addTravail(Employe employe, Projet projet, Date date, int duree, String commentaire){
	Travail trav = new Travail();
	trav.setEmploye(employe);
	trav.setProjet(projet);
	trav.setDate(date);
	trav.setDuree(duree);
	trav.setCommentaire(commentaire);
	addTravail(trav);
	}

	public Travail getTravailbyID(int id) {
		System.out.println("\nRECUPERATION DU TRAVAIL : "+id);
		return em.find(Travail.class, id);
	}

	public List<Travail> getTravailbyEmploye(Employe empl){
		System.out.println("\nRECUPERATION DU TEMPS DE TRAVAIL DE L'EMPLOYE : "+empl.getNom());
		TypedQuery<Travail> queryName = em.createNamedQuery("Travail.findByEmploye", Travail.class);
		queryName.setParameter("emplVar", empl);
		return queryName.getResultList();
	}

	public List<Travail> getTravailbyProjet(Projet pro){
		System.out.println("\nRECUPERATION DES TEMPS DE TRAVAIL DU PROJET : "+pro.getCode());
		TypedQuery<Travail> queryName = em.createNamedQuery("Travail.findByProjet", Travail.class);
		queryName.setParameter("projetVar", pro);
		return queryName.getResultList();
	}

	public List<Travail> getAllTravail() {
		System.out.println("\nListe des temps de travail\n");
	    TypedQuery<Travail> query = em.createNamedQuery("Travail.findAll", Travail.class);
	    return query.getResultList();
	}
}

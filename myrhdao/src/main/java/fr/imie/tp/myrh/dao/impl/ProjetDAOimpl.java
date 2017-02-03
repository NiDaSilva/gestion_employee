package fr.imie.tp.myrh.dao.impl;

import fr.imie.tp.myrh.dao.ifc.IProjetDAO;
import fr.imie.tp.myrh.dao.model.Projet;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ProjetDAOimpl implements IProjetDAO {
	  EntityManager em = EntityManagerImpl.getEm();

    public void addProjet(Projet projet){
		System.out.println("\nCREATION D'UN PROJET");
		EntityTransaction trx = em.getTransaction();
		trx.begin();
		em.persist(projet);
		trx.commit();
		System.out.println("Projet "+projet.getCode()+" enregistré avec l'id "+projet.getId());
	}

	public void addProjet(String code, String description, Date dateDebut, Date dateFin){
    	Projet projo = new Projet(code,description,dateDebut,dateFin);
    	addProjet(projo);

	}

	public Projet getProjetById(int id){
		System.out.println("\nRECUPERATION DU PROJET : "+id);
		return em.find(Projet.class, id);
	}

	public Projet getProjetByCode(String code){
		System.out.println("\nRECUPERATION DU PROJET : "+code);
		TypedQuery<Projet> queryCode = em.createNamedQuery("Projet.findByCode", Projet.class);
		queryCode.setParameter("codeVar", code);
		return queryCode.getSingleResult();
	}

	public List<Projet> getAllProjets() {
	    System.out.println("\nListe des Projets");
	    TypedQuery<Projet> query = em.createNamedQuery("Projet.findAll", Projet.class);
	    return query.getResultList();
	}
}

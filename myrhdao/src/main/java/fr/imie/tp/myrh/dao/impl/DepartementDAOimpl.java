package fr.imie.tp.myrh.dao.impl;

import fr.imie.tp.myrh.dao.ifc.IDepartementDAO;
import fr.imie.tp.myrh.dao.model.Departement;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DepartementDAOimpl implements IDepartementDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRhPersistenceUnit");
    EntityManager em = emf.createEntityManager();

    public void addDepartement(Departement dep){
		System.out.println("\nCREATION D'UN DEPARTEMENT");
		EntityTransaction trx = em.getTransaction();
		trx.begin();
		em.persist(dep);
		trx.commit();
	}

	public Departement getDepartementById(int id){
		System.out.println("\nRECUPERATION DU DEPARTEMENT : "+id);
		return em.find(Departement.class, id);
	}

	public Departement getDepartementByCode(String code){
		System.out.println("\nRECUPERATION DU DEPARTEMENT : "+code);
		TypedQuery<Departement> queryCode = em.createNamedQuery("Departement.findByCode", Departement.class);
		queryCode.setParameter("codeVar", code);
		return queryCode.getSingleResult();
	}

	public List<Departement> getAllDepartements() {
	    System.out.println("\nListe des Departements");
	    TypedQuery<Departement> query = em.createNamedQuery("Departement.findAll", Departement.class);
	    return query.getResultList();
	}
}

package fr.imie.tp.myrh.dao.impl;

import fr.imie.tp.myrh.dao.ifc.IEmployeDAO;
import fr.imie.tp.myrh.dao.model.Employe;

import java.util.List;

import javax.persistence.*;

public class EmployeDAOimpl implements IEmployeDAO {
	  EntityManager em = EntityManagerImpl.getEm();

    public void addEmploye(Employe emp){
		System.out.println("\nCREATION D'UN EMPLOYE");
		EntityTransaction trx = em.getTransaction();
		trx.begin();
		em.persist(emp);
		trx.commit();
	    System.out.println("Utilisateur "+ emp.getNom() +" "+ emp.getPrenom() +" enregistré avec l'id "+emp.getId());
	}

	public Employe getEmployeById(int id){
		System.out.println("\nRECUPERATION DE L'EMPLOYE : "+id);
		return em.find(Employe.class, id);
	}

	public Employe getEmployeByName(String name){
		System.out.println("\nRECUPERATION DE L'EMPLOYE : "+name);
		TypedQuery<Employe> queryName = em.createNamedQuery("Employe.findByName", Employe.class);
		queryName.setParameter("nomVar", name);
		return queryName.getSingleResult();
	}

	public List<Employe> getAllEmploye() {
		System.out.println("\nListe des Employés");
	    TypedQuery<Employe> query = em.createNamedQuery("Employe.findAll", Employe.class);
	    return query.getResultList();
	}
}

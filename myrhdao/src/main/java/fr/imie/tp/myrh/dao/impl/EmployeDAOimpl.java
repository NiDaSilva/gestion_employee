package fr.imie.tp.myrh.dao.impl;

import fr.imie.tp.myrh.dao.ifc.IEmployeDAO;
import fr.imie.tp.myrh.dao.model.Employe;

import java.util.List;

import javax.persistence.*;

/**
 * Created by ndasilva on 31/01/2017.
 */
public class EmployeDAOimpl implements IEmployeDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRhPersistenceUnit");
    EntityManager em = emf.createEntityManager();

    public void addEmploye(Employe emp){
		System.out.println("\nCREATION D'UN EMPLOYE");
		EntityTransaction trx = em.getTransaction();
		trx.begin();
		em.persist(emp);
		trx.commit();
	}

	public Employe getEmployeById(int id){
		System.out.println("\nRECUPERATION D'UN EMPLOYE PAR SON ID");
		Employe emp = em.find(Employe.class, id);
		return  emp;
	}

	public Employe getEmployeByName(String name){
		System.out.println("\nRECUPERATION D'UN EMPLOYE PAR SON NOM");
		Employe emp = em.find(Employe.class, name);
		return  emp;
	}

	public List<Employe> getAllEmploye() {
		System.out.println("\nListe des Employés");
	    TypedQuery<Employe> query = em.createNamedQuery("Employe.findAll", Employe.class);
	    return query.getResultList();
	}
}

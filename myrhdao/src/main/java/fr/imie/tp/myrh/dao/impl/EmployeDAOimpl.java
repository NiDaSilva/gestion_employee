package fr.imie.tp.myrh.dao.impl;

import fr.imie.tp.myrh.dao.ifc.IEmployeDAO;
import fr.imie.tp.myrh.dao.model.Employe;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * Created by ndasilva on 31/01/2017.
 */
public class EmployeDAOimpl implements IEmployeDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRhPersistenceUnit");
    EntityManager em = emf.createEntityManager();

	public List<Employe> getAllEmploye() {
		System.out.println("\nListe des Employés");
	    TypedQuery<Employe> query = em.createNamedQuery("Employe.findAll", Employe.class);
	    return query.getResultList();
	}
}

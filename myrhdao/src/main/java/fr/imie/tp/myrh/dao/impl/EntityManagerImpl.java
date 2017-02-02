package fr.imie.tp.myrh.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerImpl {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRhPersistenceUnit");
    static EntityManager em = emf.createEntityManager();

	/**
	 * @return the EntityManagerFactory
	 */
	public static EntityManagerFactory getEmf() {
		return emf;
	}

	/**
	 * @return the em
	 */
	public static EntityManager getEm() {
		return em;
	}
    
    

}

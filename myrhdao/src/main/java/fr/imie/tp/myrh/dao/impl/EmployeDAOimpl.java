package fr.imie.tp.myrh.dao.impl;

import fr.imie.tp.myrh.dao.ifc.IEmployeDAO;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by ndasilva on 31/01/2017.
 */
public class EmployeDAOimpl implements IEmployeDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRhPersistenceUnit");
}

package fr.imie.tp.myrh.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import fr.imie.tp.myrh.dao.ifc.IEmployeDAO;
import fr.imie.tp.myrh.dao.model.Employe;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by drobin on 31/01/2017.
 */
public class EmployeDAOImplTest {
    // static IEmployeDAO _employeDaoService = new EmployeDAOimpl();

    static IEmployeDAO _employeDaoService; 

    public static void main(String[] args) {
    	
    }
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		_employeDaoService = new EmployeDAOimpl();
	}

    @AfterClass
    public static void tearDownAfterClass() throws Exception{

    }
	
	@Test
	public void testGetAllEmploye() {
		List<Employe> emps = _employeDaoService.getAllEmploye();
		assertNotNull(emps);
		assertEquals(7, emps.size());
		assertEquals("Prenom incorrect", "Gertrude", emps.get(0).getPrenom());
	}

}

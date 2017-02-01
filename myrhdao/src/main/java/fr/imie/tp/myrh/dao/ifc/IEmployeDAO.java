package fr.imie.tp.myrh.dao.ifc;

import java.util.List;

import fr.imie.tp.myrh.dao.model.Employe;

public interface IEmployeDAO {
	
    public void addEmploye(Employe emp);

	public Employe getEmployeById(int id);

	public Employe getEmployeByName(String name);
    
    public List<Employe> getAllEmploye();

}

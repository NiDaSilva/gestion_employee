package fr.imie.tp.myrh.dao.ifc;

import java.util.List;

import fr.imie.tp.myrh.dao.model.Departement;

public interface IDepartementDAO {
	
    public void addDepartement(Departement departement);

	public Departement getDepartementById(int id);

	public Departement getDepartementByCode(String code);
    
    public List<Departement> getAllDepartements();

}

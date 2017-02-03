package fr.imie.tp.myrh.dao.ifc;

import java.util.List;

import fr.imie.tp.myrh.dao.model.Departement;

public interface IDepartementDAO {
	
    void addDepartement(Departement departement);
    void addDepartement(String code, String description);

	Departement getDepartementById(int id);

	Departement getDepartementByCode(String code);
    
    List<Departement> getAllDepartements();

}

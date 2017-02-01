package fr.imie.tp.myrh.dao.ifc;

import java.util.List;

import fr.imie.tp.myrh.dao.model.Projet;

public interface IProjetDAO {
	
    public void addProjet(Projet Projet);

	public Projet getProjetById(int id);

	public Projet getProjetByCode(String code);
    
    public List<Projet> getAllProjets();

}

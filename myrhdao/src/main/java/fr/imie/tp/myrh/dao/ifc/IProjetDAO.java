package fr.imie.tp.myrh.dao.ifc;

import java.util.Date;
import java.util.List;

import fr.imie.tp.myrh.dao.model.Projet;

public interface IProjetDAO {
	
    void addProjet(Projet Projet);

    void addProjet(String code, String description, Date dateDebut, Date dateFin);

	Projet getProjetById(int id);

	Projet getProjetByCode(String code);
    
    List<Projet> getAllProjets();

}

package fr.imie.tp.myrh.dao.ifc;

import java.util.List;

import fr.imie.tp.myrh.dao.model.Employe;
import fr.imie.tp.myrh.dao.model.Projet;
import fr.imie.tp.myrh.dao.model.Travail;

public interface ITravailDAO {
	
    public void addTravail(Travail trav);

	public Travail getTravailbyID(int id);

	public List<Travail> getTravailbyEmploye(Employe empl);

	public List<Travail> getTravailbyProjet(Projet pro);
    
    public List<Travail> getAllTravail();

}

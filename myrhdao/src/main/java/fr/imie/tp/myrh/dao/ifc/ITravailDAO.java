package fr.imie.tp.myrh.dao.ifc;

import java.util.Date;
import java.util.List;

import fr.imie.tp.myrh.dao.model.Employe;
import fr.imie.tp.myrh.dao.model.Projet;
import fr.imie.tp.myrh.dao.model.Travail;

public interface ITravailDAO {
	
    void addTravail(Travail trav);
	void addTravail(Employe employe, Projet projet, Date date, int duree, String commentaire);

	Travail getTravailbyID(int id);

	List<Travail> getTravailbyEmploye(Employe empl);

	List<Travail> getTravailbyProjet(Projet pro);
    
    List<Travail> getAllTravail();

}

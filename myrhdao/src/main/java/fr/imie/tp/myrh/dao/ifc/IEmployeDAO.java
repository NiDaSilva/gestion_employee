package fr.imie.tp.myrh.dao.ifc;

import java.util.Date;
import java.util.List;

import fr.imie.tp.myrh.dao.model.Departement;
import fr.imie.tp.myrh.dao.model.Employe;

public interface IEmployeDAO {

    public void addEmploye(Employe emp);
    
    public void addEmploye(String nom, String prenom, Departement dep, String num_secu, double salaire, Date dateEmbauche, Date dateFinEmbauche);

	public Employe getEmployeById(int id);

	public Employe getEmployeByName(String name);
    
    public List<Employe> getAllEmploye();

}

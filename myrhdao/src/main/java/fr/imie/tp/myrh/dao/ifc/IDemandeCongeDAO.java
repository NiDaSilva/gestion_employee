package fr.imie.tp.myrh.dao.ifc;

import fr.imie.tp.myrh.dao.model.DemandeConge;
import fr.imie.tp.myrh.dao.model.Employe;

import java.util.List;

/**
 * Created by ndasilva on 01/02/2017.
 */
public interface IDemandeCongeDAO {

    public void addDemande(DemandeConge dem);

    public List<DemandeConge> getAllDemande();

    public List<DemandeConge> getDemandeByEmploye(Employe empl);
}

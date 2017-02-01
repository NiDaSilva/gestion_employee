package fr.imie.tp.myrh.dao.ifc;

import fr.imie.tp.myrh.dao.model.DemandeConge;

import java.util.List;

/**
 * Created by ndasilva on 01/02/2017.
 */
public interface IDemandeCongeDAO {

    public List<DemandeConge> getAllDemande();

    public List<DemandeConge> getDemandeByEmploye();
}

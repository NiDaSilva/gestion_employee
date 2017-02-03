package fr.imie.tp.myrh.dao.ifc;

import fr.imie.tp.myrh.dao.model.DemandeConge;
import fr.imie.tp.myrh.dao.model.Employe;
import fr.imie.tp.myrh.dao.model.Status;

import java.util.Date;
import java.util.List;

/**
 * Created by ndasilva on 01/02/2017.
 */
public interface IDemandeCongeDAO {

    void addDemande(DemandeConge dem);
    void addDemande(Employe employe, Status status, String motif, int nbJour, Date dateDemande, Date dateDebut, Date dateFin);

    List<DemandeConge> getAllDemande();

    List<DemandeConge> getDemandeByEmploye(Employe empl);
}

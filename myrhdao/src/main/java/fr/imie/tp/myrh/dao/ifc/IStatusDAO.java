package fr.imie.tp.myrh.dao.ifc;

import fr.imie.tp.myrh.dao.model.Status;

import java.util.List;

/**
 * Created by ndasilva on 02/02/2017.
 */
public interface IStatusDAO {

    public void addStatus(Status stat);

    public List<Status> getAllStatus();
}

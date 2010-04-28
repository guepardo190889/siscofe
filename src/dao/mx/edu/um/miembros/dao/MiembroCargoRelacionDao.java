
package mx.edu.um.miembros.dao;

import java.util.List;

import mx.edu.um.dao.Dao;
import mx.edu.um.miembros.model.MiembroCargoRelacion;

public interface MiembroCargoRelacionDao extends Dao {

    /**
     * Retrieves all of the miembroCargoRelacions
     */
    public List getMiembroCargoRelacions(MiembroCargoRelacion miembroCargoRelacion);

    /**
     * Gets miembroCargoRelacion's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the miembroCargoRelacion's id
     * @return miembroCargoRelacion populated miembroCargoRelacion object
     */
    public MiembroCargoRelacion getMiembroCargoRelacion(final Integer id);

    /**
     * Saves a miembroCargoRelacion's information
     * @param miembroCargoRelacion the object to be saved
     */    
    public void saveMiembroCargoRelacion(MiembroCargoRelacion miembroCargoRelacion);

    /**
     * Removes a miembroCargoRelacion from the database by id
     * @param id the miembroCargoRelacion's id
     */
    public void removeMiembroCargoRelacion(final Integer id);
}


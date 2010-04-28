
package mx.edu.um.miembros.service;

import java.util.List;

import mx.edu.um.service.Manager;
import mx.edu.um.miembros.model.MiembroCargoRelacion;
import mx.edu.um.miembros.dao.MiembroCargoRelacionDao;

public interface MiembroCargoRelacionManager extends Manager {
    /**
     * Retrieves all of the miembroCargoRelacions
     */
    public List getMiembroCargoRelacions(MiembroCargoRelacion miembroCargoRelacion);

    /**
     * Gets miembroCargoRelacion's information based on id.
     * @param id the miembroCargoRelacion's id
     * @return miembroCargoRelacion populated miembroCargoRelacion object
     */
    public MiembroCargoRelacion getMiembroCargoRelacion(final String id);

    /**
     * Saves a miembroCargoRelacion's information
     * @param miembroCargoRelacion the object to be saved
     */
    public void saveMiembroCargoRelacion(MiembroCargoRelacion miembroCargoRelacion);

    /**
     * Removes a miembroCargoRelacion from the database by id
     * @param id the miembroCargoRelacion's id
     */
    public void removeMiembroCargoRelacion(final String id);
}


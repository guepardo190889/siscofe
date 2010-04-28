
package mx.edu.um.cargos.service;

import java.util.List;

import mx.edu.um.service.Manager;
import mx.edu.um.cargos.model.Cargo;
import mx.edu.um.cargos.dao.CargoDao;

public interface CargoManager extends Manager {
    /**
     * Retrieves all of the cargos
     */
    public List getCargos(Cargo cargo);

    /**
     * Gets cargo's information based on id.
     * @param id the cargo's id
     * @return cargo populated cargo object
     */
    public Cargo getCargo(final String id);

    /**
     * Saves a cargo's information
     * @param cargo the object to be saved
     */
    public void saveCargo(Cargo cargo);

    /**
     * Removes a cargo from the database by id
     * @param id the cargo's id
     */
    public void removeCargo(final String id);
}


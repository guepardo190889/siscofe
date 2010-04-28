
package mx.edu.um.cargos.dao;

import java.util.List;

import mx.edu.um.dao.Dao;
import mx.edu.um.cargos.model.Cargo;

public interface CargoDao extends Dao {

    /**
     * Retrieves all of the cargos
     */
    public List getCargos(Cargo cargo);

    /**
     * Gets cargo's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the cargo's id
     * @return cargo populated cargo object
     */
    public Cargo getCargo(final Integer id);

    /**
     * Saves a cargo's information
     * @param cargo the object to be saved
     */    
    public void saveCargo(Cargo cargo);

    /**
     * Removes a cargo from the database by id
     * @param id the cargo's id
     */
    public void removeCargo(final Integer id);
}


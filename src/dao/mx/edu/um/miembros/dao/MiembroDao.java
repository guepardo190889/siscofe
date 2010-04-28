
package mx.edu.um.miembros.dao;

import java.util.List;

import mx.edu.um.dao.Dao;
import mx.edu.um.miembros.model.Miembro;

public interface MiembroDao extends Dao {

    /**
     * Retrieves all of the miembros
     */
    public List getMiembros(Miembro miembro);

    /**
     * Gets miembro's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the miembro's id
     * @return miembro populated miembro object
     */
    public Miembro getMiembro(final Integer id);

    /**
     * Saves a miembro's information
     * @param miembro the object to be saved
     */    
    public void saveMiembro(Miembro miembro);

    /**
     * Removes a miembro from the database by id
     * @param id the miembro's id
     */
    public void removeMiembro(final Integer id);
}


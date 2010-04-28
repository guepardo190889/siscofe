
package mx.edu.um.miembros.service;

import java.util.List;

import mx.edu.um.miembros.model.Miembro;
import mx.edu.um.service.Manager;

public interface MiembroManager extends Manager {
    /**
     * Retrieves all of the miembros
     */
    public List getMiembros(Miembro miembro);

    /**
     * Gets miembro's information based on id.
     * @param id the miembro's id
     * @return miembro populated miembro object
     */
    public Miembro getMiembro(final String id);

    /**
     * Saves a miembro's information
     * @param miembro the object to be saved
     */
    public void saveMiembro(Miembro miembro);

    /**
     * Removes a miembro from the database by id
     * @param id the miembro's id
     */
    public void removeMiembro(final String id);
}


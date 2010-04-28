
package mx.edu.um.miembros.service.impl;

import java.util.List;

import mx.edu.um.service.impl.BaseManager;
import mx.edu.um.miembros.model.Miembro;
import mx.edu.um.miembros.dao.MiembroDao;
import mx.edu.um.miembros.service.MiembroManager;

public class MiembroManagerImpl extends BaseManager implements MiembroManager {
    private MiembroDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setMiembroDao(MiembroDao dao) {
        this.dao = dao;
    }

    /**
     * @see mx.edu.um.miembros.service.MiembroManager#getMiembros(mx.edu.um.miembros.model.Miembro)
     */
    public List getMiembros(final Miembro miembro) {
        return dao.getMiembros(miembro);
    }

    /**
     * @see mx.edu.um.miembros.service.MiembroManager#getMiembro(String id)
     */
    public Miembro getMiembro(final String id) {
        return dao.getMiembro(new Integer(id));
    }

    /**
     * @see mx.edu.um.miembros.service.MiembroManager#saveMiembro(Miembro miembro)
     */
    public void saveMiembro(Miembro miembro) {
        dao.saveMiembro(miembro);
    }

    /**
     * @see mx.edu.um.miembros.service.MiembroManager#removeMiembro(String id)
     */
    public void removeMiembro(final String id) {
        dao.removeMiembro(new Integer(id));
    }
}

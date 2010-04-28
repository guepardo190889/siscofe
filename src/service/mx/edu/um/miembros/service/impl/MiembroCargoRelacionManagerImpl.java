
package mx.edu.um.miembros.service.impl;

import java.util.List;

import mx.edu.um.service.impl.BaseManager;
import mx.edu.um.miembros.model.MiembroCargoRelacion;
import mx.edu.um.miembros.dao.MiembroCargoRelacionDao;
import mx.edu.um.miembros.service.MiembroCargoRelacionManager;

public class MiembroCargoRelacionManagerImpl extends BaseManager implements MiembroCargoRelacionManager {
    private MiembroCargoRelacionDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setMiembroCargoRelacionDao(MiembroCargoRelacionDao dao) {
        this.dao = dao;
    }

    /**
     * @see mx.edu.um.miembros.service.MiembroCargoRelacionManager#getMiembroCargoRelacions(mx.edu.um.miembros.model.MiembroCargoRelacion)
     */
    public List getMiembroCargoRelacions(final MiembroCargoRelacion miembroCargoRelacion) {
        return dao.getMiembroCargoRelacions(miembroCargoRelacion);
    }

    /**
     * @see mx.edu.um.miembros.service.MiembroCargoRelacionManager#getMiembroCargoRelacion(String id)
     */
    public MiembroCargoRelacion getMiembroCargoRelacion(final String id) {
        return dao.getMiembroCargoRelacion(new Integer(id));
    }

    /**
     * @see mx.edu.um.miembros.service.MiembroCargoRelacionManager#saveMiembroCargoRelacion(MiembroCargoRelacion miembroCargoRelacion)
     */
    public void saveMiembroCargoRelacion(MiembroCargoRelacion miembroCargoRelacion) {
        dao.saveMiembroCargoRelacion(miembroCargoRelacion);
    }

    /**
     * @see mx.edu.um.miembros.service.MiembroCargoRelacionManager#removeMiembroCargoRelacion(String id)
     */
    public void removeMiembroCargoRelacion(final String id) {
        dao.removeMiembroCargoRelacion(new Integer(id));
    }
}

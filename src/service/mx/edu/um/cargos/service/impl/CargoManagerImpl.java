
package mx.edu.um.cargos.service.impl;

import java.util.List;

import mx.edu.um.service.impl.BaseManager;
import mx.edu.um.cargos.model.Cargo;
import mx.edu.um.cargos.dao.CargoDao;
import mx.edu.um.cargos.service.CargoManager;

public class CargoManagerImpl extends BaseManager implements CargoManager {
    private CargoDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setCargoDao(CargoDao dao) {
        this.dao = dao;
    }

    /**
     * @see mx.edu.um.cargos.service.CargoManager#getCargos(mx.edu.um.cargos.model.Cargo)
     */
    public List getCargos(final Cargo cargo) {
        return dao.getCargos(cargo);
    }

    /**
     * @see mx.edu.um.cargos.service.CargoManager#getCargo(String id)
     */
    public Cargo getCargo(final String id) {
        return dao.getCargo(new Integer(id));
    }

    /**
     * @see mx.edu.um.cargos.service.CargoManager#saveCargo(Cargo cargo)
     */
    public void saveCargo(Cargo cargo) {
        dao.saveCargo(cargo);
    }

    /**
     * @see mx.edu.um.cargos.service.CargoManager#removeCargo(String id)
     */
    public void removeCargo(final String id) {
        dao.removeCargo(new Integer(id));
    }
}

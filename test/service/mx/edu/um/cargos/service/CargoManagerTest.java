
package mx.edu.um.cargos.service;

import java.util.List;
import java.util.ArrayList;

import mx.edu.um.service.BaseManagerTestCase;
import mx.edu.um.cargos.dao.CargoDao;
import mx.edu.um.cargos.model.Cargo;
import mx.edu.um.cargos.service.impl.CargoManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class CargoManagerTest extends BaseManagerTestCase {
    private final String cargoId = "1";
    private CargoManagerImpl cargoManager = new CargoManagerImpl();
    private Mock cargoDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        cargoDao = new Mock(CargoDao.class);
        cargoManager.setCargoDao((CargoDao) cargoDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        cargoManager = null;
    }

    public void testGetCargos() throws Exception {
        List results = new ArrayList();
        Cargo cargo = new Cargo();
        results.add(cargo);

        // set expected behavior on dao
        cargoDao.expects(once()).method("getCargos")
            .will(returnValue(results));

        List cargos = cargoManager.getCargos(null);
        assertTrue(cargos.size() == 1);
        cargoDao.verify();
    }

    public void testGetCargo() throws Exception {
        // set expected behavior on dao
        cargoDao.expects(once()).method("getCargo")
            .will(returnValue(new Cargo()));
        Cargo cargo = cargoManager.getCargo(cargoId);
        assertTrue(cargo != null);
        cargoDao.verify();
    }

    public void testSaveCargo() throws Exception {
        Cargo cargo = new Cargo();

        // set expected behavior on dao
        cargoDao.expects(once()).method("saveCargo")
            .with(same(cargo)).isVoid();

        cargoManager.saveCargo(cargo);
        cargoDao.verify();
    }

    public void testAddAndRemoveCargo() throws Exception {
        Cargo cargo = new Cargo();

        // set required fields
        cargo.setNombre("NqDfIpGqYfHiJyPpRsWaNyMfKwHoEwQoTbVbAyKmQySuUeEmPuUoAuBjWqOsKbOoGeFoNoTgFvJlXiBnUlHoYwHwKiTbMvTtAyGl");
        cargo.setDescripcion("TwOvCqZtOpZgRdKcBtEvRcDsRkFjNiQuQkJlIqLwNbBvDgFrItSzSvSoXhZfEhOfRyNjEsFwEfHuPjBzWlSjBuUvDkKyQrSyJfQaAuHfQtTvCgFqHgDzFtZpYpUqVyLhPnRlKpWrAuQbQnTfJiStJh");

        // set expected behavior on dao
        cargoDao.expects(once()).method("saveCargo")
            .with(same(cargo)).isVoid();
        cargoManager.saveCargo(cargo);
        cargoDao.verify();

        // reset expectations
        cargoDao.reset();

        cargoDao.expects(once()).method("removeCargo").with(eq(new Integer(cargoId)));
        cargoManager.removeCargo(cargoId);
        cargoDao.verify();

        // reset expectations
        cargoDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(Cargo.class, cargo.getId());
        cargoDao.expects(once()).method("removeCargo").isVoid();
        cargoDao.expects(once()).method("getCargo").will(throwException(ex));
        cargoManager.removeCargo(cargoId);
        try {
            cargoManager.getCargo(cargoId);
            fail("Cargo with identifier '" + cargoId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        cargoDao.verify();
    }
}

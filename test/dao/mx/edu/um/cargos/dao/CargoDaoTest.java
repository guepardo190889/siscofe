package mx.edu.um.cargos.dao;

import java.util.List;

import mx.edu.um.dao.BaseDaoTestCase;
import mx.edu.um.cargos.model.Cargo;

import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.orm.ObjectRetrievalFailureException;

public class CargoDaoTest extends BaseDaoTestCase {
    private Integer cargoId = new Integer("1");
    private CargoDao dao = null;

    public void setCargoDao(CargoDao dao) {
        this.dao = dao;
    }

    public void testAddCargo() throws Exception {
        Cargo cargo = new Cargo();

        // set required fields

        java.lang.String nombre = "TwRhOcVlFpMpPuXvPjWyVuWjYcPuQtZhZlTqTmMjCuCzDiJxEhBtNcSgJiIuAiPxZbKrEhZoVlUkPpKcFoZwYbLyTfNuCdVcPvYl";
        cargo.setNombre(nombre);        

        java.lang.String descripcion = "PgUgOaQbVoPwKeYeDmSyIpAxQiYsMnKzQiLgLpDkDbHjYbTrGnQwQgZuYuSqQuMfQsTgNzFoUkEbUgDnEgYcEqKrSrOaRkInWdPyFqNaEtIeLkIuDpDvIgGuBcEeYyXhZgRxViYoUbGqRhVcBjWbTg";
        cargo.setDescripcion(descripcion);        

        dao.saveCargo(cargo);

        // verify a primary key was assigned
        assertNotNull(cargo.getId());

        // verify set fields are same after save
        assertEquals(nombre, cargo.getNombre());
        assertEquals(descripcion, cargo.getDescripcion());
    }

    public void testGetCargo() throws Exception {
        Cargo cargo = dao.getCargo(cargoId);
        assertNotNull(cargo);
    }

    public void testGetCargos() throws Exception {
        Cargo cargo = new Cargo();

        List results = dao.getCargos(cargo);
        assertTrue(results.size() > 0);
    }

    public void testSaveCargo() throws Exception {
        Cargo cargo = dao.getCargo(cargoId);

        // update required fields
        java.lang.String nombre = "HwCwJlYoJyOkQxHkLpCyPhVbPsOrYkPaWcGzCrJbTyEqOrMeYrWgMcZfHxQpCeIkDeItUlUgBjNxNkGoUyLhRxYcBiLyIcRwLpOr";
        cargo.setNombre(nombre);        
        java.lang.String descripcion = "VbFqKlTqHdFxDlTxSgSvBxJiLuUbAkYgMjKyKpFkUuLgTcAiIqZwVvGsRrUlRxVgWfSpAjJwFzRsFiFtCqHpMyYxVlHpKsWbIsArMeZeSqMzVsKjNuUnKbEkJeMeEjAkYhFwMoMgHgYjNzOwYkAeYa";
        cargo.setDescripcion(descripcion);        

        dao.saveCargo(cargo);

        assertEquals(nombre, cargo.getNombre());
        assertEquals(descripcion, cargo.getDescripcion());
    }

    public void testRemoveCargo() throws Exception {
        Integer removeId = new Integer("3");
        dao.removeCargo(removeId);
        try {
            dao.getCargo(removeId);
            fail("cargo found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        } catch (InvalidDataAccessApiUsageException e) { // Spring 2.0 throws this one
            assertNotNull(e.getMessage());        	
        }
    }
}

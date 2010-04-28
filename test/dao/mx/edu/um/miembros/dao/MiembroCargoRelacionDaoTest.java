package mx.edu.um.miembros.dao;

import java.util.List;

import mx.edu.um.dao.BaseDaoTestCase;
import mx.edu.um.miembros.model.MiembroCargoRelacion;

import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.orm.ObjectRetrievalFailureException;

public class MiembroCargoRelacionDaoTest extends BaseDaoTestCase {
    private Integer miembroCargoRelacionId = new Integer("1");
    private MiembroCargoRelacionDao dao = null;

    public void setMiembroCargoRelacionDao(MiembroCargoRelacionDao dao) {
        this.dao = dao;
    }

    public void testAddMiembroCargoRelacion() throws Exception {
        MiembroCargoRelacion miembroCargoRelacion = new MiembroCargoRelacion();

        // set required fields

        java.util.Date fechaInicial = new java.util.Date();
        miembroCargoRelacion.setFechaInicial(fechaInicial);        

        java.util.Date fechaFinal = new java.util.Date();
        miembroCargoRelacion.setFechaFinal(fechaFinal);        

        dao.saveMiembroCargoRelacion(miembroCargoRelacion);

        // verify a primary key was assigned
        assertNotNull(miembroCargoRelacion.getId());

        // verify set fields are same after save
        assertEquals(fechaInicial, miembroCargoRelacion.getFechaInicial());
        assertEquals(fechaFinal, miembroCargoRelacion.getFechaFinal());
    }

    public void testGetMiembroCargoRelacion() throws Exception {
        MiembroCargoRelacion miembroCargoRelacion = dao.getMiembroCargoRelacion(miembroCargoRelacionId);
        assertNotNull(miembroCargoRelacion);
    }

    public void testGetMiembroCargoRelacions() throws Exception {
        MiembroCargoRelacion miembroCargoRelacion = new MiembroCargoRelacion();

        List results = dao.getMiembroCargoRelacions(miembroCargoRelacion);
        assertTrue(results.size() > 0);
    }

    public void testSaveMiembroCargoRelacion() throws Exception {
        MiembroCargoRelacion miembroCargoRelacion = dao.getMiembroCargoRelacion(miembroCargoRelacionId);

        // update required fields
        java.util.Date fechaInicial = new java.util.Date();
        miembroCargoRelacion.setFechaInicial(fechaInicial);        
        java.util.Date fechaFinal = new java.util.Date();
        miembroCargoRelacion.setFechaFinal(fechaFinal);        

        dao.saveMiembroCargoRelacion(miembroCargoRelacion);

        assertEquals(fechaInicial, miembroCargoRelacion.getFechaInicial());
        assertEquals(fechaFinal, miembroCargoRelacion.getFechaFinal());
    }

    public void testRemoveMiembroCargoRelacion() throws Exception {
        Integer removeId = new Integer("3");
        dao.removeMiembroCargoRelacion(removeId);
        try {
            dao.getMiembroCargoRelacion(removeId);
            fail("miembroCargoRelacion found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        } catch (InvalidDataAccessApiUsageException e) { // Spring 2.0 throws this one
            assertNotNull(e.getMessage());        	
        }
    }
}


package mx.edu.um.miembros.service;

import java.util.List;
import java.util.ArrayList;

import mx.edu.um.service.BaseManagerTestCase;
import mx.edu.um.miembros.dao.MiembroCargoRelacionDao;
import mx.edu.um.miembros.model.MiembroCargoRelacion;
import mx.edu.um.miembros.service.impl.MiembroCargoRelacionManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class MiembroCargoRelacionManagerTest extends BaseManagerTestCase {
    private final String miembroCargoRelacionId = "1";
    private MiembroCargoRelacionManagerImpl miembroCargoRelacionManager = new MiembroCargoRelacionManagerImpl();
    private Mock miembroCargoRelacionDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        miembroCargoRelacionDao = new Mock(MiembroCargoRelacionDao.class);
        miembroCargoRelacionManager.setMiembroCargoRelacionDao((MiembroCargoRelacionDao) miembroCargoRelacionDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        miembroCargoRelacionManager = null;
    }

    public void testGetMiembroCargoRelacions() throws Exception {
        List results = new ArrayList();
        MiembroCargoRelacion miembroCargoRelacion = new MiembroCargoRelacion();
        results.add(miembroCargoRelacion);

        // set expected behavior on dao
        miembroCargoRelacionDao.expects(once()).method("getMiembroCargoRelacions")
            .will(returnValue(results));

        List miembroCargoRelacions = miembroCargoRelacionManager.getMiembroCargoRelacions(null);
        assertTrue(miembroCargoRelacions.size() == 1);
        miembroCargoRelacionDao.verify();
    }

    public void testGetMiembroCargoRelacion() throws Exception {
        // set expected behavior on dao
        miembroCargoRelacionDao.expects(once()).method("getMiembroCargoRelacion")
            .will(returnValue(new MiembroCargoRelacion()));
        MiembroCargoRelacion miembroCargoRelacion = miembroCargoRelacionManager.getMiembroCargoRelacion(miembroCargoRelacionId);
        assertTrue(miembroCargoRelacion != null);
        miembroCargoRelacionDao.verify();
    }

    public void testSaveMiembroCargoRelacion() throws Exception {
        MiembroCargoRelacion miembroCargoRelacion = new MiembroCargoRelacion();

        // set expected behavior on dao
        miembroCargoRelacionDao.expects(once()).method("saveMiembroCargoRelacion")
            .with(same(miembroCargoRelacion)).isVoid();

        miembroCargoRelacionManager.saveMiembroCargoRelacion(miembroCargoRelacion);
        miembroCargoRelacionDao.verify();
    }

    public void testAddAndRemoveMiembroCargoRelacion() throws Exception {
        MiembroCargoRelacion miembroCargoRelacion = new MiembroCargoRelacion();

        // set required fields
        miembroCargoRelacion.setFechaInicial(new java.util.Date());
        miembroCargoRelacion.setFechaFinal(new java.util.Date());

        // set expected behavior on dao
        miembroCargoRelacionDao.expects(once()).method("saveMiembroCargoRelacion")
            .with(same(miembroCargoRelacion)).isVoid();
        miembroCargoRelacionManager.saveMiembroCargoRelacion(miembroCargoRelacion);
        miembroCargoRelacionDao.verify();

        // reset expectations
        miembroCargoRelacionDao.reset();

        miembroCargoRelacionDao.expects(once()).method("removeMiembroCargoRelacion").with(eq(new Integer(miembroCargoRelacionId)));
        miembroCargoRelacionManager.removeMiembroCargoRelacion(miembroCargoRelacionId);
        miembroCargoRelacionDao.verify();

        // reset expectations
        miembroCargoRelacionDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(MiembroCargoRelacion.class, miembroCargoRelacion.getId());
        miembroCargoRelacionDao.expects(once()).method("removeMiembroCargoRelacion").isVoid();
        miembroCargoRelacionDao.expects(once()).method("getMiembroCargoRelacion").will(throwException(ex));
        miembroCargoRelacionManager.removeMiembroCargoRelacion(miembroCargoRelacionId);
        try {
            miembroCargoRelacionManager.getMiembroCargoRelacion(miembroCargoRelacionId);
            fail("MiembroCargoRelacion with identifier '" + miembroCargoRelacionId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        miembroCargoRelacionDao.verify();
    }
}

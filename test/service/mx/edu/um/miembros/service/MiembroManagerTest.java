
package mx.edu.um.miembros.service;

import java.util.List;
import java.util.ArrayList;

import mx.edu.um.service.BaseManagerTestCase;
import mx.edu.um.miembros.dao.MiembroDao;
import mx.edu.um.miembros.model.Miembro;
import mx.edu.um.miembros.service.impl.MiembroManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class MiembroManagerTest extends BaseManagerTestCase {
    private final String miembroId = "1";
    private MiembroManagerImpl miembroManager = new MiembroManagerImpl();
    private Mock miembroDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        miembroDao = new Mock(MiembroDao.class);
        miembroManager.setMiembroDao((MiembroDao) miembroDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        miembroManager = null;
    }

    public void testGetMiembros() throws Exception {
        List results = new ArrayList();
        Miembro miembro = new Miembro();
        results.add(miembro);

        // set expected behavior on dao
        miembroDao.expects(once()).method("getMiembros")
            .will(returnValue(results));

        List miembros = miembroManager.getMiembros(null);
        assertTrue(miembros.size() == 1);
        miembroDao.verify();
    }

    public void testGetMiembro() throws Exception {
        // set expected behavior on dao
        miembroDao.expects(once()).method("getMiembro")
            .will(returnValue(new Miembro()));
        Miembro miembro = miembroManager.getMiembro(miembroId);
        assertTrue(miembro != null);
        miembroDao.verify();
    }

    public void testSaveMiembro() throws Exception {
        Miembro miembro = new Miembro();

        // set expected behavior on dao
        miembroDao.expects(once()).method("saveMiembro")
            .with(same(miembro)).isVoid();

        miembroManager.saveMiembro(miembro);
        miembroDao.verify();
    }

    public void testAddAndRemoveMiembro() throws Exception {
        Miembro miembro = new Miembro();

        // set required fields
        miembro.setNombre("LsElRvNpIgWyCmMoAhZzIlTbOlCvYt");
        miembro.setApellidoMaterno("XbXrXgZwCeKoKpJdTnWmWlZcWsVcJq");
        miembro.setApellidoPaterno("EbXhLxTvPhAlFqWuJnNyCzUyDlUqOn");
        miembro.setSexo("X");
        miembro.setEstadoCivil("Jj");
        miembro.setModoIngreso("Cn");
        miembro.setStatus("Is");
        miembro.setEstudioVeintiochoCreencias("W");
        miembro.setFechaBautismo(new java.util.Date());
        miembro.setFechaJuntaAdministrativa(new java.util.Date());
        miembro.setFechaJuntaDirectiva(new java.util.Date());
        miembro.setNumeroVotosJuntaAdministrativa(new Integer(1471888946));
        miembro.setNumeroVotosJuntaDirectiva(new Integer(970252009));

        // set expected behavior on dao
        miembroDao.expects(once()).method("saveMiembro")
            .with(same(miembro)).isVoid();
        miembroManager.saveMiembro(miembro);
        miembroDao.verify();

        // reset expectations
        miembroDao.reset();

        miembroDao.expects(once()).method("removeMiembro").with(eq(new Integer(miembroId)));
        miembroManager.removeMiembro(miembroId);
        miembroDao.verify();

        // reset expectations
        miembroDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(Miembro.class, miembro.getId());
        miembroDao.expects(once()).method("removeMiembro").isVoid();
        miembroDao.expects(once()).method("getMiembro").will(throwException(ex));
        miembroManager.removeMiembro(miembroId);
        try {
            miembroManager.getMiembro(miembroId);
            fail("Miembro with identifier '" + miembroId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        miembroDao.verify();
    }
}

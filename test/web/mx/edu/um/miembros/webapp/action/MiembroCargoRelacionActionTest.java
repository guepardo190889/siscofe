package mx.edu.um.miembros.webapp.action;

import mx.edu.um.webapp.action.BaseStrutsTestCase;
import mx.edu.um.Constants;
import mx.edu.um.miembros.webapp.form.MiembroCargoRelacionForm;

public class MiembroCargoRelacionActionTest extends BaseStrutsTestCase {

    public MiembroCargoRelacionActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveMiembroCargoRelacion");
        addRequestParameter("method", "Save");

        MiembroCargoRelacionForm miembroCargoRelacionForm = new MiembroCargoRelacionForm();
        // set required fields
        miembroCargoRelacionForm.setFechaInicial("28/04/2010");
        miembroCargoRelacionForm.setFechaFinal("28/04/2010");

        request.setAttribute(Constants.MIEMBROCARGORELACION_KEY, miembroCargoRelacionForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/miembroCargoRelacions");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.MIEMBROCARGORELACION_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editMiembroCargoRelacion");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.MIEMBROCARGORELACION_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editMiembroCargoRelacion");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        MiembroCargoRelacionForm miembroCargoRelacionForm = (MiembroCargoRelacionForm) request.getAttribute(Constants.MIEMBROCARGORELACION_KEY);
        assertNotNull(miembroCargoRelacionForm);

        setRequestPathInfo("/saveMiembroCargoRelacion");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request
        miembroCargoRelacionForm.setFechaInicial("28/04/2010");
        miembroCargoRelacionForm.setFechaFinal("28/04/2010");

        request.setAttribute(Constants.MIEMBROCARGORELACION_KEY, miembroCargoRelacionForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"miembroCargoRelacion.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editMiembroCargoRelacion");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}

package mx.edu.um.miembros.webapp.action;

import mx.edu.um.webapp.action.BaseStrutsTestCase;
import mx.edu.um.Constants;
import mx.edu.um.miembros.webapp.form.MiembroForm;

public class MiembroActionTest extends BaseStrutsTestCase {

    public MiembroActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveMiembro");
        addRequestParameter("method", "Save");

        MiembroForm miembroForm = new MiembroForm();
        // set required fields
        miembroForm.setNombre("GaRlZzBoPnIeCtUlYpOxQzKuTjQsTv");
        miembroForm.setApellidoMaterno("QcHrPdImBtPaLqXeRuLzIpKuYaRuHl");
        miembroForm.setApellidoPaterno("WfOpZnElCvTiZpMkJpFpIzMwPwRvZn");
        miembroForm.setSexo("O");
        miembroForm.setEstadoCivil("Cf");
        miembroForm.setModoIngreso("Fw");
        miembroForm.setStatus("Wf");
        miembroForm.setEstudioVeintiochoCreencias("N");
        miembroForm.setFechaBautismo("27/04/2010");
        miembroForm.setFechaJuntaAdministrativa("27/04/2010");
        miembroForm.setFechaJuntaDirectiva("27/04/2010");
        miembroForm.setNumeroVotosJuntaAdministrativa("1921166797");
        miembroForm.setNumeroVotosJuntaDirectiva("1319777482");

        request.setAttribute(Constants.MIEMBRO_KEY, miembroForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/miembros");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.MIEMBRO_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editMiembro");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.MIEMBRO_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editMiembro");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        MiembroForm miembroForm = (MiembroForm) request.getAttribute(Constants.MIEMBRO_KEY);
        assertNotNull(miembroForm);

        setRequestPathInfo("/saveMiembro");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request
        miembroForm.setNombre("EdEnPzAaNzRxMmBkIoBaGsCdJqEkLw");
        miembroForm.setApellidoMaterno("XsTyIkCmRvPbRqFgDdMrEeIrNzDcCb");
        miembroForm.setApellidoPaterno("WkMkUhYtPnKwXkDnMwVyGrHpKaRrUg");
        miembroForm.setSexo("M");
        miembroForm.setEstadoCivil("Av");
        miembroForm.setModoIngreso("Ug");
        miembroForm.setStatus("Zr");
        miembroForm.setEstudioVeintiochoCreencias("J");
        miembroForm.setFechaBautismo("27/04/2010");
        miembroForm.setFechaJuntaAdministrativa("27/04/2010");
        miembroForm.setFechaJuntaDirectiva("27/04/2010");
        miembroForm.setNumeroVotosJuntaAdministrativa("117114445");
        miembroForm.setNumeroVotosJuntaDirectiva("307369079");

        request.setAttribute(Constants.MIEMBRO_KEY, miembroForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"miembro.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editMiembro");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}

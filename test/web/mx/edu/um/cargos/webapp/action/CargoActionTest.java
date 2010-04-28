package mx.edu.um.cargos.webapp.action;

import mx.edu.um.webapp.action.BaseStrutsTestCase;
import mx.edu.um.Constants;
import mx.edu.um.cargos.webapp.form.CargoForm;

public class CargoActionTest extends BaseStrutsTestCase {

    public CargoActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveCargo");
        addRequestParameter("method", "Save");

        CargoForm cargoForm = new CargoForm();
        // set required fields
        cargoForm.setNombre("KuMgDnXgJfLxBuMlHzWbYkAiUsQqQtLiAeRiMcMyCmWeZdOoXqYnXfQhPyVnNsHzKwKnWiHcCuFvEtVjOtGgEeSxNnVfWqFlUxJv");
        cargoForm.setDescripcion("IfWiEcKhRhViAmImZoRuPrMsLzPpYcUbJpSaUjYmFjJsTiSzNpWoWxJcEqYeXeSzJgKqUqKqJqMwGcSnVcIyRgVrYoGyMfHlSyKgPaGeHoBoZvMvOhFsEiHwGnEmJgKwKhQqGgQcSbDuEzDrIgBlLg");

        request.setAttribute(Constants.CARGO_KEY, cargoForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/cargos");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.CARGO_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editCargo");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.CARGO_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editCargo");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        CargoForm cargoForm = (CargoForm) request.getAttribute(Constants.CARGO_KEY);
        assertNotNull(cargoForm);

        setRequestPathInfo("/saveCargo");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request
        cargoForm.setNombre("YxIwApAcQvAiNcAlRnAxCqPaMcEzIeLyLeFbSxMnIfTnMzDwVjQsGiPdObFiRhHvCkRwVmSrAjQgHlRgTkRxZyJgVhQtTxGqBmMf");
        cargoForm.setDescripcion("IdUpClHdWxBeBnYeKtOjGjXnUhCgZfXdCmYePdSaNqFwShXzFlCvAzIfJqTjXoOcAtBjMwIsZtRzHsJnVcGjDpOfDzHsFbLhFhGkXpJsDbHyUeVtPsUxOfTsCoQfAiDkLwZmVrLhStPgPvNrSvVyIq");

        request.setAttribute(Constants.CARGO_KEY, cargoForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"cargo.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editCargo");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}

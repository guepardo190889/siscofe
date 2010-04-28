
package mx.edu.um.cargos.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import mx.edu.um.webapp.action.BaseAction;
import mx.edu.um.Constants;
import mx.edu.um.cargos.model.Cargo;
import mx.edu.um.cargos.service.CargoManager;
import mx.edu.um.cargos.webapp.form.CargoForm;

/**
 * Action class to handle CRUD on a Cargo object
 *
 * @struts.action name="cargoForm" path="/cargos" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="cargoForm" path="/editCargo" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="cargoForm" path="/saveCargo" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/cargos/cargoForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/cargos/cargoList.jsp"
 * @struts.action-forward name="search" path="/cargos.html" redirect="true"
 */
public final class CargoAction extends BaseAction {
    public ActionForward cancel(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request,
                                HttpServletResponse response)
    throws Exception {
        return mapping.findForward("search");
    }

    public ActionForward delete(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request,
                                HttpServletResponse response)
    throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("Entering 'delete' method");
        }

        ActionMessages messages = new ActionMessages();
        CargoForm cargoForm = (CargoForm) form;

        // Exceptions are caught by ActionExceptionHandler
        CargoManager mgr = (CargoManager) getBean("cargoManager");
        mgr.removeCargo(cargoForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("cargo.deleted"));

        // save messages in session, so they'll survive the redirect
        saveMessages(request.getSession(), messages);

        return mapping.findForward("search");
    }

    public ActionForward edit(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request,
                              HttpServletResponse response)
    throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("Entering 'edit' method");
        }

        CargoForm cargoForm = (CargoForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (cargoForm.getId() != null) {
            CargoManager mgr = (CargoManager) getBean("cargoManager");
            Cargo cargo = mgr.getCargo(cargoForm.getId());
            cargoForm = (CargoForm) convert(cargo);
            updateFormBean(mapping, request, cargoForm);
        }

        return mapping.findForward("edit");
    }

    public ActionForward save(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request,
                              HttpServletResponse response)
    throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("Entering 'save' method");
        }

        // Extract attributes and parameters we will need
        ActionMessages messages = new ActionMessages();
        CargoForm cargoForm = (CargoForm) form;
        boolean isNew = ("".equals(cargoForm.getId()) || cargoForm.getId() == null);

        CargoManager mgr = (CargoManager) getBean("cargoManager");
        Cargo cargo = (Cargo) convert(cargoForm);
        mgr.saveCargo(cargo);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("cargo.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("cargo.updated"));
            saveMessages(request, messages);

            return mapping.findForward("edit");
        }
    }

    public ActionForward search(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request,
                                HttpServletResponse response)
    throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("Entering 'search' method");
        }

        CargoForm cargoForm = (CargoForm) form;
        Cargo cargo = (Cargo) convert(cargoForm);

        CargoManager mgr = (CargoManager) getBean("cargoManager");
        request.setAttribute(Constants.CARGO_LIST, mgr.getCargos(cargo));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}

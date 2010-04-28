
package mx.edu.um.miembros.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import mx.edu.um.webapp.action.BaseAction;
import mx.edu.um.Constants;
import mx.edu.um.miembros.model.MiembroCargoRelacion;
import mx.edu.um.miembros.service.MiembroCargoRelacionManager;
import mx.edu.um.miembros.webapp.form.MiembroCargoRelacionForm;

/**
 * Action class to handle CRUD on a MiembroCargoRelacion object
 *
 * @struts.action name="miembroCargoRelacionForm" path="/miembroCargoRelacions" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="miembroCargoRelacionForm" path="/editMiembroCargoRelacion" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="miembroCargoRelacionForm" path="/saveMiembroCargoRelacion" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/miembros/miembroCargoRelacionForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/miembros/miembroCargoRelacionList.jsp"
 * @struts.action-forward name="search" path="/miembroCargoRelacions.html" redirect="true"
 */
public final class MiembroCargoRelacionAction extends BaseAction {
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
        MiembroCargoRelacionForm miembroCargoRelacionForm = (MiembroCargoRelacionForm) form;

        // Exceptions are caught by ActionExceptionHandler
        MiembroCargoRelacionManager mgr = (MiembroCargoRelacionManager) getBean("miembroCargoRelacionManager");
        mgr.removeMiembroCargoRelacion(miembroCargoRelacionForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("miembroCargoRelacion.deleted"));

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

        MiembroCargoRelacionForm miembroCargoRelacionForm = (MiembroCargoRelacionForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (miembroCargoRelacionForm.getId() != null) {
            MiembroCargoRelacionManager mgr = (MiembroCargoRelacionManager) getBean("miembroCargoRelacionManager");
            MiembroCargoRelacion miembroCargoRelacion = mgr.getMiembroCargoRelacion(miembroCargoRelacionForm.getId());
            miembroCargoRelacionForm = (MiembroCargoRelacionForm) convert(miembroCargoRelacion);
            updateFormBean(mapping, request, miembroCargoRelacionForm);
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
        MiembroCargoRelacionForm miembroCargoRelacionForm = (MiembroCargoRelacionForm) form;
        boolean isNew = ("".equals(miembroCargoRelacionForm.getId()) || miembroCargoRelacionForm.getId() == null);

        MiembroCargoRelacionManager mgr = (MiembroCargoRelacionManager) getBean("miembroCargoRelacionManager");
        MiembroCargoRelacion miembroCargoRelacion = (MiembroCargoRelacion) convert(miembroCargoRelacionForm);
        mgr.saveMiembroCargoRelacion(miembroCargoRelacion);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("miembroCargoRelacion.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("miembroCargoRelacion.updated"));
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

        MiembroCargoRelacionForm miembroCargoRelacionForm = (MiembroCargoRelacionForm) form;
        MiembroCargoRelacion miembroCargoRelacion = (MiembroCargoRelacion) convert(miembroCargoRelacionForm);

        MiembroCargoRelacionManager mgr = (MiembroCargoRelacionManager) getBean("miembroCargoRelacionManager");
        request.setAttribute(Constants.MIEMBROCARGORELACION_LIST, mgr.getMiembroCargoRelacions(miembroCargoRelacion));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}

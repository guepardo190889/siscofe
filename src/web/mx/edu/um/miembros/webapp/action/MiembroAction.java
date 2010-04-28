
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
import mx.edu.um.miembros.model.Miembro;
import mx.edu.um.miembros.service.MiembroManager;
import mx.edu.um.miembros.webapp.form.MiembroForm;

/**
 * Action class to handle CRUD on a Miembro object
 *
 * @struts.action name="miembroForm" path="/miembros" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="miembroForm" path="/editMiembro" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="miembroForm" path="/saveMiembro" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/miembros/miembroForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/miembros/miembroList.jsp"
 * @struts.action-forward name="search" path="/miembros.html" redirect="true"
 */
public final class MiembroAction extends BaseAction {
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
        MiembroForm miembroForm = (MiembroForm) form;

        // Exceptions are caught by ActionExceptionHandler
        MiembroManager mgr = (MiembroManager) getBean("miembroManager");
        mgr.removeMiembro(miembroForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("miembro.deleted"));

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

        MiembroForm miembroForm = (MiembroForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (miembroForm.getId() != null) {
            MiembroManager mgr = (MiembroManager) getBean("miembroManager");
            Miembro miembro = mgr.getMiembro(miembroForm.getId());
            miembroForm = (MiembroForm) convert(miembro);
            updateFormBean(mapping, request, miembroForm);
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
        MiembroForm miembroForm = (MiembroForm) form;
        boolean isNew = ("".equals(miembroForm.getId()) || miembroForm.getId() == null);

        MiembroManager mgr = (MiembroManager) getBean("miembroManager");
        Miembro miembro = (Miembro) convert(miembroForm);
        mgr.saveMiembro(miembro);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("miembro.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("miembro.updated"));
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

        MiembroForm miembroForm = (MiembroForm) form;
        Miembro miembro = (Miembro) convert(miembroForm);

        MiembroManager mgr = (MiembroManager) getBean("miembroManager");
        request.setAttribute(Constants.MIEMBRO_LIST, mgr.getMiembros(miembro));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}

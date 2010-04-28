<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="miembroCargoRelacionDetail.title"/></title>
<content tag="heading"><fmt:message key="miembroCargoRelacionDetail.heading"/></content>

<html:form action="saveMiembroCargoRelacion" method="post" styleId="miembroCargoRelacionForm" onsubmit="return validateMiembroCargoRelacionForm(this)">
<ul>

<html:hidden property="id"/>

<html:hidden property="version"/>

    <li>
        <siscofeSt:label styleClass="desc" key="miembroCargoRelacionForm.miembro"/>
        <html:errors property="miembro"/>
        <html:text property="miembro" styleId="miembro" styleClass="text medium"/>

    </li>

    <li>
        <siscofeSt:label styleClass="desc" key="miembroCargoRelacionForm.cargo"/>
        <html:errors property="cargo"/>
        <html:text property="cargo" styleId="cargo" styleClass="text medium"/>

    </li>

    <li>
        <siscofeSt:label styleClass="desc" key="miembroCargoRelacionForm.fechaInicial"/>
        <html:errors property="fechaInicial"/>
        <html:text property="fechaInicial" styleId="fechaInicial" styleClass="text medium"/>

    </li>

    <li>
        <siscofeSt:label styleClass="desc" key="miembroCargoRelacionForm.fechaFinal"/>
        <html:errors property="fechaFinal"/>
        <html:text property="fechaFinal" styleId="fechaFinal" styleClass="text medium"/>

    </li>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('MiembroCargoRelacion')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("miembroCargoRelacionForm"));
</script>

<html:javascript formName="miembroCargoRelacionForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>

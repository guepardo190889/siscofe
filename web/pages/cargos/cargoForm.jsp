<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="cargoDetail.title"/></title>
<content tag="heading"><fmt:message key="cargoDetail.heading"/></content>

<html:form action="saveCargo" method="post" styleId="cargoForm" onsubmit="return validateCargoForm(this)">
<ul>

<html:hidden property="id"/>

<html:hidden property="version"/>

    <li>
        <siscofeSt:label styleClass="desc" key="cargoForm.nombre"/>
        <html:errors property="nombre"/>
        <html:text property="nombre" styleId="nombre" styleClass="text medium"/>

    </li>

    <li>
        <siscofeSt:label styleClass="desc" key="cargoForm.descripcion"/>
        <html:errors property="descripcion"/>
        <html:text property="descripcion" styleId="descripcion" styleClass="text medium"/>

    </li>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('Cargo')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("cargoForm"));
</script>

<html:javascript formName="cargoForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>

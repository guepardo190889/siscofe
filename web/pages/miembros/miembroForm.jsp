<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="miembroDetail.title"/></title>
<content tag="heading"><fmt:message key="miembroDetail.heading"/></content>

<html:form action="saveMiembro" method="post" styleId="miembroForm" onsubmit="return validateMiembroForm(this)">
<ul>

<html:hidden property="id"/>

<html:hidden property="version"/>

    <li>
        <siscofeSt:label styleClass="desc" key="miembroForm.nombre"/>
        <html:errors property="nombre"/>
        <html:text property="nombre" styleId="nombre" styleClass="text medium"/>

    </li>

    <li>
        <siscofeSt:label styleClass="desc" key="miembroForm.apellidoMaterno"/>
        <html:errors property="apellidoMaterno"/>
        <html:text property="apellidoMaterno" styleId="apellidoMaterno" styleClass="text medium"/>

    </li>

    <li>
        <siscofeSt:label styleClass="desc" key="miembroForm.apellidoPaterno"/>
        <html:errors property="apellidoPaterno"/>
        <html:text property="apellidoPaterno" styleId="apellidoPaterno" styleClass="text medium"/>

    </li>

    <li>
        <siscofeSt:label styleClass="desc" key="miembroForm.sexo"/>
        <html:errors property="sexo"/>
        <html:text property="sexo" styleId="sexo" styleClass="text medium"/>

    </li>

    <li>
        <siscofeSt:label styleClass="desc" key="miembroForm.estadoCivil"/>
        <html:errors property="estadoCivil"/>
        <html:text property="estadoCivil" styleId="estadoCivil" styleClass="text medium"/>

    </li>

    <li>
        <siscofeSt:label styleClass="desc" key="miembroForm.nombreConyuge"/>
        <html:errors property="nombreConyuge"/>
        <html:text property="nombreConyuge" styleId="nombreConyuge" styleClass="text medium"/>

    </li>

    <li>
        <siscofeSt:label styleClass="desc" key="miembroForm.telefonoFijo"/>
        <html:errors property="telefonoFijo"/>
        <html:text property="telefonoFijo" styleId="telefonoFijo" styleClass="text medium"/>

    </li>

    <li>
        <siscofeSt:label styleClass="desc" key="miembroForm.telefonoCelular"/>
        <html:errors property="telefonoCelular"/>
        <html:text property="telefonoCelular" styleId="telefonoCelular" styleClass="text medium"/>

    </li>

    <li>
        <siscofeSt:label styleClass="desc" key="miembroForm.correoElectronico"/>
        <html:errors property="correoElectronico"/>
        <html:text property="correoElectronico" styleId="correoElectronico" styleClass="text medium"/>

    </li>

    <li>
        <siscofeSt:label styleClass="desc" key="miembroForm.observaciones"/>
        <html:errors property="observaciones"/>
        <html:text property="observaciones" styleId="observaciones" styleClass="text medium"/>

    </li>

    <li>
        <siscofeSt:label styleClass="desc" key="miembroForm.lugarBautismo"/>
        <html:errors property="lugarBautismo"/>
        <html:text property="lugarBautismo" styleId="lugarBautismo" styleClass="text medium"/>

    </li>

    <li>
        <siscofeSt:label styleClass="desc" key="miembroForm.ministroOficiante"/>
        <html:errors property="ministroOficiante"/>
        <html:text property="ministroOficiante" styleId="ministroOficiante" styleClass="text medium"/>

    </li>

    <li>
        <siscofeSt:label styleClass="desc" key="miembroForm.religionAnterior"/>
        <html:errors property="religionAnterior"/>
        <html:text property="religionAnterior" styleId="religionAnterior" styleClass="text medium"/>

    </li>

    <li>
        <siscofeSt:label styleClass="desc" key="miembroForm.modoIngreso"/>
        <html:errors property="modoIngreso"/>
        <html:text property="modoIngreso" styleId="modoIngreso" styleClass="text medium"/>

    </li>

    <li>
        <siscofeSt:label styleClass="desc" key="miembroForm.cursoBiblico"/>
        <html:errors property="cursoBiblico"/>
        <html:text property="cursoBiblico" styleId="cursoBiblico" styleClass="text medium"/>

    </li>

    <li>
        <siscofeSt:label styleClass="desc" key="miembroForm.comoConocioIglesia"/>
        <html:errors property="comoConocioIglesia"/>
        <html:text property="comoConocioIglesia" styleId="comoConocioIglesia" styleClass="text medium"/>

    </li>

    <li>
        <siscofeSt:label styleClass="desc" key="miembroForm.status"/>
        <html:errors property="status"/>
        <html:text property="status" styleId="status" styleClass="text medium"/>

    </li>

    <li>
        <siscofeSt:label styleClass="desc" key="miembroForm.estudioVeintiochoCreencias"/>
        <html:errors property="estudioVeintiochoCreencias"/>
        <html:text property="estudioVeintiochoCreencias" styleId="estudioVeintiochoCreencias" styleClass="text medium"/>

    </li>

    <li>
        <siscofeSt:label styleClass="desc" key="miembroForm.diezmando"/>
        <html:errors property="diezmando"/>
        <html:text property="diezmando" styleId="diezmando" styleClass="text medium"/>

    </li>

    <li>
        <siscofeSt:label styleClass="desc" key="miembroForm.fechaBautismo"/>
        <html:errors property="fechaBautismo"/>
        <html:text property="fechaBautismo" styleId="fechaBautismo" styleClass="text medium"/>

    </li>

    <li>
        <siscofeSt:label styleClass="desc" key="miembroForm.fechaJuntaAdministrativa"/>
        <html:errors property="fechaJuntaAdministrativa"/>
        <html:text property="fechaJuntaAdministrativa" styleId="fechaJuntaAdministrativa" styleClass="text medium"/>

    </li>

    <li>
        <siscofeSt:label styleClass="desc" key="miembroForm.fechaJuntaDirectiva"/>
        <html:errors property="fechaJuntaDirectiva"/>
        <html:text property="fechaJuntaDirectiva" styleId="fechaJuntaDirectiva" styleClass="text medium"/>

    </li>

    <li>
        <siscofeSt:label styleClass="desc" key="miembroForm.numeroVotosJuntaAdministrativa"/>
        <html:errors property="numeroVotosJuntaAdministrativa"/>
        <html:text property="numeroVotosJuntaAdministrativa" styleId="numeroVotosJuntaAdministrativa" styleClass="text medium"/>

    </li>

    <li>
        <siscofeSt:label styleClass="desc" key="miembroForm.numeroVotosJuntaDirectiva"/>
        <html:errors property="numeroVotosJuntaDirectiva"/>
        <html:text property="numeroVotosJuntaDirectiva" styleId="numeroVotosJuntaDirectiva" styleClass="text medium"/>

    </li>

    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('Miembro')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("miembroForm"));
</script>

<html:javascript formName="miembroForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>

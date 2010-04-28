<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="miembroList.title"/></title>
<content tag="heading"><fmt:message key="miembroList.heading"/></content>
<meta name="menu" content="MiembroMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editMiembro.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="miembroList" cellspacing="0" cellpadding="0"
    id="miembroList" pagesize="25" class="table miembroList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editMiembro.html" paramId="id" paramProperty="id"
        titleKey="miembroForm.id"/>
    <display:column property="nombre" sortable="true" headerClass="sortable"
         titleKey="miembroForm.nombre"/>
    <display:column property="apellidoMaterno" sortable="true" headerClass="sortable"
         titleKey="miembroForm.apellidoMaterno"/>
    <display:column property="apellidoPaterno" sortable="true" headerClass="sortable"
         titleKey="miembroForm.apellidoPaterno"/>
    <display:column property="sexo" sortable="true" headerClass="sortable"
         titleKey="miembroForm.sexo"/>
    <display:column property="estadoCivil" sortable="true" headerClass="sortable"
         titleKey="miembroForm.estadoCivil"/>
    <display:column property="nombreConyuge" sortable="true" headerClass="sortable"
         titleKey="miembroForm.nombreConyuge"/>
    <display:column property="telefonoFijo" sortable="true" headerClass="sortable"
         titleKey="miembroForm.telefonoFijo"/>
    <display:column property="telefonoCelular" sortable="true" headerClass="sortable"
         titleKey="miembroForm.telefonoCelular"/>
    <display:column property="correoElectronico" sortable="true" headerClass="sortable"
         titleKey="miembroForm.correoElectronico"/>
    <display:column property="observaciones" sortable="true" headerClass="sortable"
         titleKey="miembroForm.observaciones"/>
    <display:column property="lugarBautismo" sortable="true" headerClass="sortable"
         titleKey="miembroForm.lugarBautismo"/>
    <display:column property="ministroOficiante" sortable="true" headerClass="sortable"
         titleKey="miembroForm.ministroOficiante"/>
    <display:column property="religionAnterior" sortable="true" headerClass="sortable"
         titleKey="miembroForm.religionAnterior"/>
    <display:column property="modoIngreso" sortable="true" headerClass="sortable"
         titleKey="miembroForm.modoIngreso"/>
    <display:column property="cursoBiblico" sortable="true" headerClass="sortable"
         titleKey="miembroForm.cursoBiblico"/>
    <display:column property="comoConocioIglesia" sortable="true" headerClass="sortable"
         titleKey="miembroForm.comoConocioIglesia"/>
    <display:column property="status" sortable="true" headerClass="sortable"
         titleKey="miembroForm.status"/>
    <display:column property="estudioVeintiochoCreencias" sortable="true" headerClass="sortable"
         titleKey="miembroForm.estudioVeintiochoCreencias"/>
    <display:column property="diezmando" sortable="true" headerClass="sortable"
         titleKey="miembroForm.diezmando"/>
    <display:column property="fechaBautismo" sortable="true" headerClass="sortable"
         titleKey="miembroForm.fechaBautismo"/>
    <display:column property="fechaJuntaAdministrativa" sortable="true" headerClass="sortable"
         titleKey="miembroForm.fechaJuntaAdministrativa"/>
    <display:column property="fechaJuntaDirectiva" sortable="true" headerClass="sortable"
         titleKey="miembroForm.fechaJuntaDirectiva"/>
    <display:column property="numeroVotosJuntaAdministrativa" sortable="true" headerClass="sortable"
         titleKey="miembroForm.numeroVotosJuntaAdministrativa"/>
    <display:column property="numeroVotosJuntaDirectiva" sortable="true" headerClass="sortable"
         titleKey="miembroForm.numeroVotosJuntaDirectiva"/>
    <display:setProperty name="paging.banner.item_name" value="miembro"/>
    <display:setProperty name="paging.banner.items_name" value="miembros"/>
</display:table>

<c:out value="${buttons}" escapeXml="false"/>

<script type="text/javascript">
    highlightTableRows("miembroList");
</script>

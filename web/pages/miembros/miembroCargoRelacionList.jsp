<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="miembroCargoRelacionList.title"/></title>
<content tag="heading"><fmt:message key="miembroCargoRelacionList.heading"/></content>
<meta name="menu" content="MiembroCargoRelacionMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editMiembroCargoRelacion.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="miembroCargoRelacionList" cellspacing="0" cellpadding="0"
    id="miembroCargoRelacionList" pagesize="25" class="table miembroCargoRelacionList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editMiembroCargoRelacion.html" paramId="id" paramProperty="id"
        titleKey="miembroCargoRelacionForm.id"/>
    <display:column property="fechaInicial" sortable="true" headerClass="sortable"
         titleKey="miembroCargoRelacionForm.fechaInicial"/>
    <display:column property="fechaFinal" sortable="true" headerClass="sortable"
         titleKey="miembroCargoRelacionForm.fechaFinal"/>
    <display:setProperty name="paging.banner.item_name" value="miembroCargoRelacion"/>
    <display:setProperty name="paging.banner.items_name" value="miembroCargoRelacions"/>
</display:table>

<c:out value="${buttons}" escapeXml="false"/>

<script type="text/javascript">
    highlightTableRows("miembroCargoRelacionList");
</script>

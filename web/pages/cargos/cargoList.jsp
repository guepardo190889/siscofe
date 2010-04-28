<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="cargoList.title"/></title>
<content tag="heading"><fmt:message key="cargoList.heading"/></content>
<meta name="menu" content="CargoMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editCargo.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="cargoList" cellspacing="0" cellpadding="0"
    id="cargoList" pagesize="25" class="table cargoList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editCargo.html" paramId="id" paramProperty="id"
        titleKey="cargoForm.id"/>
    <display:column property="nombre" sortable="true" headerClass="sortable"
         titleKey="cargoForm.nombre"/>
    <display:column property="descripcion" sortable="true" headerClass="sortable"
         titleKey="cargoForm.descripcion"/>
    <display:setProperty name="paging.banner.item_name" value="cargo"/>
    <display:setProperty name="paging.banner.items_name" value="cargos"/>
</display:table>

<c:out value="${buttons}" escapeXml="false"/>

<script type="text/javascript">
    highlightTableRows("cargoList");
</script>

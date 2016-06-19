<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<html lang="en" ng-app="webapp">
<spring:url value="/resources/css" var="css"  />
<spring:url value="/resources/images" var="images" />
<spring:url value="/resources/js" var="js" />
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%-- include file for header --%>
<jsp:include page="../shared/header.jsp">
	<jsp:param value="iniitian" name="title"/>
	<jsp:param value="${css}" name="css"/>	
</jsp:include>
<%-- ------------------- --%>
<body>
	<%-- include file for menu --%>	
	<jsp:include page="../shared/menu.jsp">
		<jsp:param value="${contextPath}" name="contextPath"/> 
	</jsp:include>
	<%-- ------------------- --%>
    <!-- Page Content -->
    <div class="container" ng-controller="CategoryController as categoryCtrl">
		<div ng-view></div>
    </div>
    <!-- /.container -->

    <div class="container">

    		<hr>
		<%-- include file for footer --%>
		<jsp:include page="../shared/footer.jsp"/>
		<%-- -------------------- --%>
    </div>
    <!-- /.container -->
	<%-- include file for scripts --%>
	<jsp:include page="../shared/scripts.jsp">
		<jsp:param value="${js}" name="js"/>
	</jsp:include>
	<%-- ----------- --%>
    <script src="${js}/app.js"></script>
    <script src="${js}/webapp.js"></script>


</body>

</html>

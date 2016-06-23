<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>


<html lang="en" ng-app="webapp">
<spring:url value="/resources/css" var="css"  />
<spring:url value="/resources/images" var="images" />
<spring:url value="/resources/js" var="js" />
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%-- include file for header --%>
<jsp:include page="./header.jsp">
	<jsp:param value="iniitian" name="title"/>
	<jsp:param value="${css}" name="css"/>	
</jsp:include>
<%-- ------------------- --%>
<body>
	<%-- include file for menu --%>
	<%@ include file="./menu.jsp" %>	
<%-- 	<jsp:include page="./menu.jsp">
		<jsp:param value="${contextPath}" name="contextPath"/> 
	</jsp:include>
 --%>	<%-- ------------------- --%>
    <!-- Page Content -->
    <div class="container" ng-controller="ProductController as productCtrl">
		<div class="row">
		
			<div class="col-md-6">
				<div class="thumbnail">
					<img ng-src="${images}/{{productCtrl.product.imageUrl}}" data-alt="{{productCtrl.product.name}}"/>
				</div>
			</div>
		
			<div class="col-md-6">
				<ul class="list-group">
				  <li class="list-group-item">Brand: {{productCtrl.product.brand}}</li>
				  <li class="list-group-item">Description {{productCtrl.product.description}}</li>
				  <li class="list-group-item">Price per unit: {{productCtrl.product.price | currency}}</li>
				  <li class="list-group-item">Unit available: {{productCtrl.product.quantity}}</li>		  
				</ul>
				<hr/>
				<sec:authorize access="not hasRole('ROLE_ADMIN')">
					<a ng-href="${contextPath}/user/addToCart/{{ productCtrl.product.id }}" class="btn btn-primary">Add To Cart</a> &#160;
				</sec:authorize>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<a ng-href="${contextPath}/admin/product/edit/{{ productCtrl.product.id }}" class="btn btn-primary">Edit</a></td>
				</sec:authorize>		
				<a ng-href="index" class="btn btn-primary">Back To Home</a></td>
			</div>
		
		</div>		
    </div>
    <!-- /.container -->

    <div class="container">

    		<hr>
		<%-- include file for footer --%>
		<jsp:include page="./footer.jsp"/>
		<%-- -------------------- --%>
    </div>
    <!-- /.container -->
	<%-- include file for scripts --%>
	<jsp:include page="./scripts.jsp">
		<jsp:param value="${js}" name="js"/>
	</jsp:include>
	<%-- ----------- --%>
    <script src="${js}/app.js"></script>
    <script src="${js}/webapp.js"></script>


</body>

</html>

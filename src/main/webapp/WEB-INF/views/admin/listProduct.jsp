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
<jsp:include page="../shared/header.jsp">
	<jsp:param value="iniitian" name="title"/>
	<jsp:param value="${css}" name="css"/>	
</jsp:include>
<%-- -------------------- --%>
<body>

	<%--include file to display the menu --%>
	<%@include file="../shared/menu.jsp" %>
	
<%-- 	<jsp:include page="../shared/menu.jsp">
		<jsp:param value="${contextPath}" name="contextPath"/> 
	</jsp:include>
 --%>	<%-- -------------------- --%>
	
    <!-- Page Content -->
    <div class="container" ng-controller="AdminProductController as adminProductCtrl">
    		<h3>Available Products</h3>
    		<hr/>
        <div class="row">
        		<div class="col-xs-12">
        		Search By Name:         		
        		<input type="text" class="form-control" ng-model="searchBy.name" />
        		<hr/>
        		<table class="table table-striped table-bordered table-responsive">
				<tr>
					<th>Name</th>
					<th>Brand</th>
					<th>Price Per Unit</th>
					<th>Available Quantity</th>
					<th></th>
				</tr>
				<tr ng-repeat="product in adminProductCtrl.products | filter:searchBy">
					<td>{{product.name}}</td>
					<td>{{product.brand}}</td>
					<td>{{product.price}}</td>
					<td>{{product.quantity}}</td>
					<td>
						<a ng-href="${contextPath}/#/product/{{ product.id }}/show/" class="btn btn-primary">View</a>
						<sec:authorize access="hasRole('ROLE_USER') and  (not hasRole('ROLE_ADMIN'))">
							<a ng-href="#" class="btn btn-primary">Add To Cart</a>
						</sec:authorize>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<a ng-href="product/edit/{{ product.id }}" class="btn btn-primary">Edit</a>
							<a ng-href="product/remove/{{ product.id }}" class="btn btn-primary">Delete</a>													
						</sec:authorize>
					</td>
				</tr>			
        		
        		
        		</table>
        
       		</div>
        </div>
     </div>

     <!-- /.container -->

    <div class="container">

	    <hr>
		<%--include file to add the footer --%>
		<jsp:include page="../shared/footer.jsp"/>
		<%-- -------------------- --%>
    </div>
    <!-- /.container -->
	
	<%-- include file for the scripts --%>
	<jsp:include page="../shared/scripts.jsp">
		<jsp:param value="${js}" name="js"/>
	</jsp:include>
	<%-- -------------------- --%>
    
    <script src="${js}/app.js"></script>
    <script src="${js}/webapp.js"></script>


</body>

</html>

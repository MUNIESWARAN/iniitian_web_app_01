<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>


<html lang="en" ng-app="webapp">
<spring:url value="/resources/css" var="css"  />
<spring:url value="/resources/images" var="images" />
<spring:url value="/resources/js" var="js" />
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="pCtr" value="1"/>
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
    <div class="container" ng-controller="ProductListController as productListCtr">    		
        
        <div class="row">        		
            <div class="col-md-3" ng-controller="CategoryController as categoryCtrl">
                <p class="lead">Category</p>
                <div class="list-group" >
                    <a ng-href="${contextPath}/productList?category={{category.id}}" class="list-group-item" ng-repeat="category in categoryCtrl.categories">{{category.name}}</a>
                </div>
            </div>
        		<div class="col-md-9">
      		<h3>Available Products</h3>
    			<hr/>        		
        		Search By Name:         		
        		<input type="text" class="form-control" ng-model="searchBy.name" />
        		<hr/>
        		<table class="table table-striped table-bordered table-responsive displayProduct">
				<tr>					
					<th>Name</th>
					<th>Brand</th>
					<th>Price Per Unit</th>
					<th colspan="2"></th>					
				</tr>
				<tr ng-repeat="product in productListCtr.products | filter:searchBy">
					<td>{{product.name}}</td>
					<td>{{product.brand}}</td>
					<td>{{product.price | currency }}</td>
					<td align="center"><img ng-src="${images}/{{product.imageUrl}}" width="100px" height="100px"/></td>
					<td>
						<a ng-href="${contextPath}/productDetail?product={{product.id}}" class="btn btn-primary">View</a>
						<sec:authorize access="hasRole('ROLE_USER')">
							<a ng-click="addToCart(product.id)" class="btn btn-primary">Add To Cart</a>							
						</sec:authorize>
						<sec:authorize access="isAnonymous()">
							<a href="loginUser" class="btn btn-primary">Add To Cart</a>
						</sec:authorize>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<a ng-href="${contextPath}/admin/product/edit/{{ product.id }}" class="btn btn-primary">Edit</a>
							<a ng-href="${contextPath}/admin/product/remove/{{ product.id }}" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this product?');">Delete</a>													
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




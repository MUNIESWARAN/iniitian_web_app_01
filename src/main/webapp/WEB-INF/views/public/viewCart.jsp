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
    <div class="container">
    		<h3>Your Cart Items</h3>
    		<hr/>
        <div class="row" ng-controller="CartController as cartCtrl">
        		<div class="col-md-12 ng-hide" ng-show="cartCtrl.hasItems">
        		<table class="table table-striped table-bordered table-responsive displayProduct" >
				<tr>					
					<th>Name</th>
					<th>Brand</th>
					<th>Price Per Unit</th>
					<th>Quantity</th>
					<th>Total Price</th>
					<th>&#160;</th>	
				</tr>
				<tr ng-repeat="cartItem in cartCtrl.cart.cartItems">
					<td>{{cartItem.product.name}}</td>
					<td>{{cartItem.product.brand}}</td>
					<td>{{cartItem.product.price | currency }}</td>
					<td>
						{{cartItem.quantity}}
					</td>
					<td>
						{{ cartItem.totalPrice | currency }}
					</td>				
					<td>
						<a ng-click="removeFromCart(cartItem.id)" class="btn btn-primary btn-danger">Remove</a>
					</td>
				</tr>				
				<tr>
					<td colspan="3">						
					</td>
					<td align="right"  valign="middle">
						<h4>Grand Total:</h4> 
					</td>
					<td>
						<h4>{{ cartCtrl.grandTotal  | currency }}</h4>
					</td>
					<td>
					</td>
				</tr>							
				<tr>
					<td colspan="6" align="center">
						<a href="${contextPath}/productList" class="btn btn-primary">Continue Shopping</a> &#160;
						<a href="${contextPath}/checkout" class="btn btn-success">Checkout</a> &#160;
					</td>					
				</tr>
        		</table>        			
        		</div>
        		<div ng-hide="cartCtrl.hasItems" class="col-md-12">
        			<h4>Your cart is empty!</h4>
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

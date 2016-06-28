<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>


<html lang="en">
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
		<h3>Shipping Address</h3>
    		<hr/>
    		<div class="row">
    			<div class="col-md-offset-3 col-md-6">
			   <form:form class="form-signin" modelAttribute="shippingAddress" novalidate="novalidate">
			   <form:hidden path="id"/>
			   <div class="form-group">
		        <label for="tbHouseNumber" class="sr-only">House Number</label>
		        <form:input type="text" id="tbHouseNumber" class="form-control" placeholder="House Or Room Number" path="houseNumber" />
		        <form:errors path="houseNumber" element="div" cssClass="error"/>			   
			   </div>
			   <div class="form-group">
		        <label for="tbAddressLine1" class="sr-only">Address Line 1</label>
		        <form:input type="text" id="tbAddressLine1" class="form-control" placeholder="Address Line 1" path="addressLine1" />			   
		        <form:errors path="addressLine1" element="div" cssClass="error"/>
			   </div>
			   <div class="form-group">
		        <label for="tbAddressLine2" class="sr-only">Address Line 2</label>
		        <form:input type="text" id="tbAddressLine2" class="form-control" placeholder="Address Line 2" path="addressLine2" />
		        <form:errors path="addressLine2" element="div" cssClass="error"/>			   
			   </div>
			   <div class="form-group">			   
		        <label for="ddlCity" class="sr-only">City</label>
				    <form:select path="city" cssClass="form-control" id="ddlCity">
				    		<form:option value="">Select City</form:option>
						<form:option value="Mumbai">Mumbai</form:option>
						<form:option value="Pune">Pune</form:option>								    		
				    </form:select>		        
		        <form:errors path="city" element="div" cssClass="error"/>
		       </div>
			   <div class="form-group">			   
		        <label for="ddlState" class="sr-only">State</label>
				    <form:select path="state" cssClass="form-control" id="ddlState">
				    		<form:option value="">Select State</form:option>
						<form:option value="Maharashtra">Maharashtra</form:option>
						<form:option value="Karnataka">Karnataka</form:option>								    		
				    </form:select>		        
		        <form:errors path="state" element="div" cssClass="error"/>
		       </div>
			   <div class="form-group">			   
		        <label for="ddlCountry" class="sr-only">Country</label>
				    <form:select path="country" cssClass="form-control" id="ddlCountry">
				    		<form:option value="">Select Country</form:option>
						<form:option value="India">India</form:option>
						<form:option value="USA">USA</form:option>								    		
				    </form:select>		        
		        <form:errors path="country" element="div" cssClass="error"/>
		       </div>
			   <div class="form-group">			   
		        <label for="tbZipcode" class="sr-only">Zip Code</label>
		        <form:input type="text" id="tbZipcode" class="form-control" placeholder="Enter Zip Code" path="zipCode" />
		        <form:errors path="zipCode" element="div" cssClass="error"/>
		       </div>
		        <button class="btn btn-warning" name="_eventId_submitShippingDetails" type="submit">Save</button>
		        <button class="btn btn-danger" name="_eventId_cancel" type="submit">Cancel</button>
		      </form:form>
					
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
    
    <script src="${js}/webapp.js"></script>


</body>

</html>

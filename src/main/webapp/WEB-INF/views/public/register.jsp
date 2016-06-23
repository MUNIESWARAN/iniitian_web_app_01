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
    		<h3>Register</h3>
    		<hr/>
        <div class="row">
        		<%-- Registration form code --%>
        		<div class="col-md-offset-2 col-md-8">
        		   
			   <form:form class="form-signin" modelAttribute="user" novalidate="novalidate">
			   <form:hidden path="id"/>
			   <div class="form-group">
		        <label for="tbFirstName" class="sr-only">First Name</label>
		        <form:input type="text" id="tbFirstName" class="form-control" placeholder="First Name" path="firstName" />
		        <form:errors path="firstName" element="div" cssClass="error"/>			   
			   </div>
			   <div class="form-group">
		        <label for="tbLastName" class="sr-only">Last Name</label>
		        <form:input type="text" id="tbLastName" class="form-control" placeholder="Last Name" path="lastName" />			   
		        <form:errors path="lastName" element="div" cssClass="error"/>
			   </div>
			   <div class="form-group">
		        <label for="tbEmailAddress" class="sr-only">Email address</label>
		        <form:input type="email" id="inputEmail" class="form-control" placeholder="Email address" path="emailAddress" />
		        <form:errors path="emailAddress" element="div" cssClass="error"/>			   
			   </div>
			   <div class="form-group">			   
		        <label for="inputPassword" class="sr-only">Choose Password</label>
		        <form:input type="password" id="inputPassword" class="form-control" placeholder="Password" path="password" />
		        <form:errors path="password" element="div" cssClass="error"/>
		       </div>
			   <div class="form-group">			   
		        <label for="inputPassword" class="sr-only">Confirm Password</label>
		        <form:input type="password" id="inputConfirmPassword" class="form-control" placeholder="Confirm Password" path="confirmPassword" />
		        <form:errors path="confirmPassword" element="div" cssClass="error"/>
		       </div>
		        <button class="btn btn-sm btn-primary" type="submit">Register</button>
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
